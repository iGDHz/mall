package com.hz.service.impl;

import com.hz.pojo.User;
import com.hz.mapper.UserMapper;
import com.hz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean InsertUser(User user) {
        return userMapper.InsertUser(user)>0;
    }

    @Override
    public User SelectByUsername(String name, int role) {
        return userMapper.SelectByUsername(name,role);
    }

    @Override
    public boolean UpdateUser(User user) {
        return userMapper.UpdateUser(user)>0;
    }

}
