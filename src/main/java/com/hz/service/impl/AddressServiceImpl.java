package com.hz.service.impl;

import com.hz.mapper.AddressMapper;
import com.hz.pojo.Address;
import com.hz.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Service
public class AddressServiceImpl implements IAddressService{

    @Autowired
    AddressMapper addressMapper;

    public List<Address> SearchProvince() {
        return addressMapper.SearchProvince();
    }

    public List<Address> SearchByName(String Province) {
        return addressMapper.SearchByName(Province);
    }
}
