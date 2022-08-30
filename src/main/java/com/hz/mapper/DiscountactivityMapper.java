package com.hz.mapper;

import com.hz.pojo.Discountactivity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Mapper
public interface DiscountactivityMapper {
    Integer InsertDiscount(@Param("discount") Discountactivity discountactivity);
    Integer UpdateDiscount(@Param("discount")Discountactivity discountactivity);
    Integer DeleteDiscount(@Param("id")Integer id);
    Discountactivity getDiscount(@Param("id") Integer id);
    List<Discountactivity> getDiscounts(@Param("userid") Integer userid);
}
