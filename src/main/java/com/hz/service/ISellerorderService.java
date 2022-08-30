package com.hz.service;

import com.hz.pojo.Sellerorder;
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
public interface ISellerorderService {

    List<Sellerorder> getOrders(@Param("totalid")Integer id);
    boolean InsertSellerOrders(@Param("orders")List<Sellerorder> orders);
    boolean InsertSellerOrder(@Param("order")Sellerorder sellerorder);

}
