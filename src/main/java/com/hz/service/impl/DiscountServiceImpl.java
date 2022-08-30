package com.hz.service.impl;

import com.hz.pojo.Discount;
import com.hz.mapper.DiscountMapper;
import com.hz.service.IDiscountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Service
public class DiscountServiceImpl  implements IDiscountService {

    @Autowired
    DiscountMapper discountMapper;

    @Override
    public String getDiscountStyle(int id) {
        return discountMapper.getDiscountStyle(id);
    }
}
