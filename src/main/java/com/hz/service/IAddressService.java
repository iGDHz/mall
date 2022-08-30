package com.hz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hz.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface IAddressService{
    public List<Address> SearchProvince();
    public List<Address> SearchByName(@Param("Name") String Province);
}
