package com.hz.mapper;

import com.hz.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Insert;
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
public interface OrderMapper {
    List<Order> getOrders(@Param("UserId")Integer id);
    Integer InsertOrders(@Param("orders")List<Order> orders);
    Integer InsertOne(@Param("order")Order order);
    Integer updateOrder(@Param("orderid") Integer id, @Param("status") Integer status);
}
