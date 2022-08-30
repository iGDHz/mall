package com.hz.service.impl;

import com.hz.pojo.Order;
import com.hz.mapper.OrderMapper;
import com.hz.service.IOrderService;
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
public class OrderServiceImpl implements IOrderService{

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> getOrders(Integer id) {
        return orderMapper.getOrders(id);
    }

    @Override
    public Integer InsertOrders(List<Order> orders) {
        return orderMapper.InsertOrders(orders);
    }

    @Override
    public boolean InsertOne(Order order) {
        return orderMapper.InsertOne(order) > 0;
    }

    @Override
    public Integer updateOrder(Integer id, Integer status) {
        return orderMapper.updateOrder(id,status);
    }

}
