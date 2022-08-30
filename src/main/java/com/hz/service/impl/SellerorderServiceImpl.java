package com.hz.service.impl;

import com.hz.pojo.Sellerorder;
import com.hz.mapper.SellerorderMapper;
import com.hz.service.ISellerorderService;
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
public class SellerorderServiceImpl implements ISellerorderService {

    @Autowired
    SellerorderMapper sellerorderMapper;

    @Override
    public List<Sellerorder> getOrders(Integer id) {
        return sellerorderMapper.getOrders(id);
    }

    @Override
    public boolean InsertSellerOrders(List<Sellerorder> orders) {
        return sellerorderMapper.InsertSellerOrders(orders)>0;
    }

    @Override
    public boolean InsertSellerOrder(Sellerorder sellerorder) {
        return sellerorderMapper.InsertSellerOrder(sellerorder)>0;
    }

}
