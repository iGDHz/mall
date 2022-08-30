package com.hz.service;

import com.hz.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface IUserService{
    boolean InsertUser(@Param("user") User user);
    User SelectByUsername(@Param("username") String name,@Param("role") int role);
    boolean UpdateUser(@Param("user")User user);
}
