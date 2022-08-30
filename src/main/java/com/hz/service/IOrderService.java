package com.hz.service;

import com.hz.pojo.Order;
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
public interface IOrderService {
    List<Order> getOrders(@Param("UserId")Integer id);
    Integer InsertOrders(@Param("orders")List<Order> orders);

    boolean InsertOne(@Param("order")Order order);
    Integer updateOrder(@Param("orderid") Integer id, @Param("status") Integer status);
}
