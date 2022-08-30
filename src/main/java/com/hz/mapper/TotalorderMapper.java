package com.hz.mapper;

import com.hz.pojo.Totalorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@Mapper
public interface TotalorderMapper{
    Integer InsertTotalOrder(@Param("order")Totalorder totalorder);
    Totalorder getTotalOrder(@Param("id")Integer id);
}
