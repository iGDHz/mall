package com.hz.service.impl;

import com.hz.pojo.Role;
import com.hz.mapper.RoleMapper;
import com.hz.service.IRoleService;
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
public class RoleServiceImpl implements IRoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public Role SearchRole(Integer roleid) {
        return roleMapper.SearchRole(roleid);
    }
}
