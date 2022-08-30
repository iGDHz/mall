package com.hz.util;

public class Constants {
    public static final String filepath = "/usr/local/mall/images";
    
    //数据库CRUD错误状态码
    @Deprecated
    public static final int C = 0x0008;
    @Deprecated
    public static final int R = 0x0004;
    @Deprecated
    public static final int U = 0x0002;
    @Deprecated
    public static final int D = 0x0001;
    
    //用户登录注册情况状态码
    @Deprecated
    public static final int USER_EXIST = 0x0080;//用户名已存在
    @Deprecated
    public static final int USER_NOEXIST = 0x0040;//用户不存在
    @Deprecated
    public static final int USER_PASSWORD = 0x0020;//密码错误
    @Deprecated
    public static final int USER_UNLOGIN = 0x0010;//用户未登录


}
