package com.hz.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class FileOperation {
    static Logger logger = LogManager.getLogger(FileOperation.class);
    //上传图片
    @Deprecated
    public static String uploadImage(HttpSession session, String filename){
        String path = Constants.filepath, filestyle = filename.substring(filename.lastIndexOf('.'));
        String srcFile = session.getServletContext().getRealPath("/") + path + File.separator + filename; //源文件
        String target = session.getServletContext().getRealPath("/")+ path + File.separator + UUID.randomUUID() + filestyle; //转移过去的目标文件
        try {
            Files.move(Paths.get(srcFile),Paths.get(target));
            logger.info("文件复制成功");
            return target.substring(target.lastIndexOf('.'));
        } catch (IOException e) {
            logger.info("文件复制失败！");
            return null;
        }
    }
}
