package com.hz.mapper;

import com.hz.pojo.Order;
import com.hz.pojo.Sellerorder;
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
public interface SellerorderMapper{
    List<Sellerorder> getOrders(@Param("totalid")Integer id);
    Integer InsertSellerOrders(@Param("orders")List<Sellerorder> orders);
    Integer InsertSellerOrder(@Param("order")Sellerorder sellerorder);
}
