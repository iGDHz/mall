package com.hz.service;

import com.hz.pojo.Discount;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface IDiscountService  {
    String getDiscountStyle(int id);
}
