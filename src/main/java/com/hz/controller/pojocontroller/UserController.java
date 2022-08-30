package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSONObject;
import com.hz.controller.BaseController;
import com.hz.pojo.User;
import com.hz.service.impl.UserServiceImpl;
import com.hz.util.Constants;
import com.hz.util.FileOperation;
import com.hz.util.Md5Utils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String UserLogin(HttpSession session, @Param("username") String username, @Param("password") String password){
        return login(session,username,password,3);
    }

    @RequestMapping(value = "/seller/login",method = RequestMethod.POST)
    public String SellerLogin(HttpSession session, @Param("username") String username, @Param("password") String password){
        return login(session,username,password,2);
    }

    @RequestMapping(value = "/user/sign", method = RequestMethod.POST)
    public String UserSign(HttpSession session, @RequestBody Map<String,Object> map){
        return sign(session,map,3);
    }

    @RequestMapping(value = "seller/sign", method = RequestMethod.POST)
    public String SellerSign(HttpSession session,@RequestBody Map<String,Object> map){
         return sign(session,map,2);
    }

    @RequestMapping(value = "user/logut",method = RequestMethod.POST)
    public void userlogout(HttpSession session){
        session.removeAttribute("user");
    }

    @RequestMapping(value = "seller/logout",method = RequestMethod.POST)
    public void sellerlogout(HttpSession session){
        session.removeAttribute("user");
    }

    /*
        用户登录
     */
    public String login(HttpSession session,String username, String password,int role) {
        JSONObject msg = new JSONObject();
        int code = 0;

        User user = userService.SelectByUsername(username, 3);//获取登录用户信息
        if (user == null) {
            code = (code & Constants.USER_NOEXIST);
        } else {
            if (password.equals(Md5Utils.md5(user.getUserPassword()))) {//验证用户密码
                session.setAttribute("user", user);
            } else code = (code & Constants.USER_PASSWORD);
        }
        msg.put("message", String.format("%04x",code));
        logger.info(">>> "+session.getId() + "尝试登录账户：", String.format("%04x",code));
        return msg.toJSONString();
    }

    /*
        用户注册
     */
    public String sign(HttpSession session,Map<String,Object> map,int role){
        User NewUser = new User();
        JSONObject message = new JSONObject();
        int code = 0;
        String userName = (String) map.get("UserName");
        User user = null;
        logger.info("用户"+NewUser.getUserName()+"正在注册");
        if((user = userService.SelectByUsername(userName,role)) == null){
            code = (code & Constants.USER_EXIST); //根据用户身份和用户名获取用户信息
            return message.toJSONString();
        }
        NewUser.setUserName((String) map.get("UserName"));
        NewUser.setUserNickname((String) map.get("UserNickname"));
        NewUser.setUserPassword(Md5Utils.md5((String) map.get("UserPassword")));
        NewUser.setUserPhone((String) map.get("UserPhone"));
        NewUser.setUserAddress((String) map.get("UserAddress"));
        NewUser.setUserMailbox((String) map.get("UserMailbox"));
        String picturename = (String) map.get("Userpicture");
        NewUser.setUserpicture(picturename);
        NewUser.setUserRealName((String) map.get("UserRealName"));
        NewUser.setUserRoleId(role);
        if(!userService.InsertUser(NewUser)){
            code = (code & Constants.C);//数据库增加出错
        }
        logger.info("注册状态码："+String.format("%04x",code));
        session.setAttribute("user",NewUser);//注册后从数据库中再获取用户信息
        message.put("message",String.format("%04x",code));
        return message.toJSONString();
    }

}
