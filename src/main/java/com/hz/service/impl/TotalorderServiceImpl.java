package com.hz.service.impl;

import com.hz.pojo.Totalorder;
import com.hz.mapper.TotalorderMapper;
import com.hz.service.ITotalorderService;
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
public class TotalorderServiceImpl implements ITotalorderService {

    @Autowired
    TotalorderMapper totalorderMapper;

    @Override
    public boolean InsertTotalOrder(Totalorder totalorder) {
        return totalorderMapper.InsertTotalOrder(totalorder)>0;
    }

    @Override
    public Totalorder getTotalOrder(Integer id) {
        return totalorderMapper.getTotalOrder(id);
    }

}
