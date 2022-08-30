package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSONObject;
import com.hz.controller.BaseController;
import com.hz.pojo.FileType;
import com.hz.util.SpringContextUtil;
import com.sun.org.apache.bcel.internal.generic.DMUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import java.util.UUID;

@Controller
@RequestMapping("/picture")
public class PictureController extends BaseController {

    static final String IMAGE_PATH = "/opt/mall/img";
    static long FILE_SIZE = 100*1024*1024;//文件大小限制


    @ResponseBody
    @RequestMapping(value = "/input",method = RequestMethod.PUT)
    public String UpLoadImage(@RequestParam("file")MultipartFile file){
        JSONObject res = new JSONObject();
        if(file.isEmpty()){
            res.put("msg","文件不能为空");
            return res.toJSONString();
        }
        String fileType = file.getContentType().split("/")[1];//检查文件类型
        logger.info("文件类型："+fileType);
        FileType bean = (FileType) SpringContextUtil.getBean(fileType);
        if(bean == null){
            res.put("msg","请选择 png、jpg、jpeg、gif、bmp 格式的图片");
            return res.toJSONString();
        }

        long size = file.getSize();//获取文件大小 定位byte
        if(size > FILE_SIZE) {
            res.put("msg","文件大小为"+size+"Byte 超过100M大小限制");
            return res.toJSONString();
        }

        String fileName = file.getOriginalFilename();//获取文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件后缀名

        SimpleDateFormat format = new SimpleDateFormat("yyyy"+File.separator+"MM");//获取年月信息
        String date = format.format(new Date());

        String path = IMAGE_PATH + File.separator + date;
        fileName = UUID.randomUUID()+suffixName;//生成随机文件名
        String fileUrl = path+File.separator+fileName;
        logger.info("文件存放位置"+fileUrl);
        File destFile = new File(fileUrl);

        if(!destFile.getParentFile().exists()){
            //目录不存在,创建父目录
            destFile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(destFile);
            res.put("msg","文件上传成功");
            res.put("filename",fileUrl);
            logger.info("文件上传成功");
        } catch (IOException e) {
            res.put("msg","文件上传失败");
            logger.info("文件上传失败");
        }
        return res.toJSONString();
    }

    @RequestMapping(value = "/getpicture",method = RequestMethod.POST)
    @ResponseBody
    public void getImage(@RequestParam(value = "image",required = false) String imageUrl, HttpServletResponse response) {
        if (imageUrl != null) {
            logger.info("请求的图片URL：" + imageUrl);
            FileInputStream in = null;//创建文件输入流
            OutputStream out = null;//创建文件输出流
            Stack<Object> sta = new Stack<>();
            try {
                File file = new File(imageUrl);
                if (!file.exists()) {
                    file = new File("/opt/mall/img/default.jpg");
                }
                in = new FileInputStream(file);
                int i = in.available();
                byte[] buffer = new byte[i];
                in.read(buffer);
                //设置输出流内容格式为图片格式
                response.setContentType("image/jpeg");
                //response的响应的编码方式为utf-8
                response.setCharacterEncoding("utf-8");
                out = response.getOutputStream();
                out.write(buffer);
            } catch (Exception e) {
                logger.info("网络错误");
            } finally {
                try {
                    in.close();
                    out.close();
                } catch (IOException e) {
                    logger.info("网络错误");
                }
            }
        }
    }


}
