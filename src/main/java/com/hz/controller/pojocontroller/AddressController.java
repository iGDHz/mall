package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hz.controller.BaseController;
import com.hz.mapper.AddressMapper;
import com.hz.pojo.Address;
import com.hz.service.impl.AddressServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Autowired
    AddressServiceImpl addressService;

    @RequestMapping(value = "/getaddress" , method = RequestMethod.POST)
    public String getAddress(@RequestParam("addressid") String addressId){
        JSONObject res = new JSONObject();
        List<Address> addressList;
        logger.info("获取AddressId为"+addressId+"的地址信息");
        if(addressId.equals("0")){
            addressList = addressService.SearchProvince();
        }else addressList = addressService.SearchByName(addressId);
        JSONArray array = new JSONArray();
        for(Address address : addressList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("address_areaId",address.getAddressAreaId());
            jsonObject.put("address_name",address.getAddressName());
            array.add(jsonObject);
        }
        res.put("addressList",array);
        return res.toJSONString();
    }

}
