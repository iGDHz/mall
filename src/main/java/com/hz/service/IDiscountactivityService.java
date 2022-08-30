package com.hz.service;

import com.hz.pojo.Discountactivity;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface IDiscountactivityService {
    boolean InsertDiscount(@Param("discount") Discountactivity discountactivity);
    Integer UpdateDiscount(@Param("discount")Discountactivity discountactivity);
    boolean DeleteDiscount(@Param("id")Integer id);
    Discountactivity getDiscount(@Param("id") Integer id);
    List<Discountactivity> getDiscounts(@Param("userid") Integer userid);
}
