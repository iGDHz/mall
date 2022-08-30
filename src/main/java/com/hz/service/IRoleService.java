package com.hz.service;

import com.hz.pojo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface IRoleService{
    public Role SearchRole(@Param("roleid") Integer roleid);
}
