package com.hz.service;

import com.hz.pojo.Totalorder;
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
public interface ITotalorderService{
    boolean InsertTotalOrder(@Param("order")Totalorder totalorder);
    Totalorder getTotalOrder(@Param("id")Integer id);
}
