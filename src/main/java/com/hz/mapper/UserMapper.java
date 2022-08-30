package com.hz.mapper;

import com.hz.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Mapper
public interface UserMapper{
    Integer InsertUser(@Param("user") User user);
    User SelectByUsername(@Param("username") String name,@Param("role") int role);
    Integer UpdateUser(@Param("user")User user);
}
