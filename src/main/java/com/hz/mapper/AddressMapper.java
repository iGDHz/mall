package com.hz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hz.pojo.Address;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.FifoCache;

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
@CacheNamespace(eviction = FifoCache.class,flushInterval = 3000,size = 512,blocking = false)
public interface AddressMapper{
    List<Address> SearchProvince();
    List<Address> SearchByName(@Param("Name") String Province);
    List<Address> SearchById(@Param("id")String areaid);
}
