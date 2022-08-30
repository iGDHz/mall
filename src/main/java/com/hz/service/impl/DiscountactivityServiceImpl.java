package com.hz.service.impl;

import com.hz.pojo.Discountactivity;
import com.hz.mapper.DiscountactivityMapper;
import com.hz.service.IDiscountactivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class DiscountactivityServiceImpl implements IDiscountactivityService{

    @Autowired
    DiscountactivityMapper discountactivityMapper;

    @Override
    public boolean InsertDiscount(Discountactivity discountactivity) {
        return discountactivityMapper.InsertDiscount(discountactivity)>0;
    }

    @Override
    public Integer UpdateDiscount(Discountactivity discountactivity) {
        return discountactivityMapper.UpdateDiscount(discountactivity);
    }

    @Override
    public boolean DeleteDiscount(Integer id) {
        return discountactivityMapper.DeleteDiscount(id)>0;
    }

    @Override
    public Discountactivity getDiscount(Integer id) {
        return discountactivityMapper.getDiscount(id);
    }

    @Override
    public List<Discountactivity> getDiscounts(Integer userid) {
        return discountactivityMapper.getDiscounts(userid);
    }
}
