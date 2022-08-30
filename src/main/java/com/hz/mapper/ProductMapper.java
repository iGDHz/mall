package com.hz.mapper;

import com.hz.pojo.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
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
public interface ProductMapper {
    List<Product> SearchProduct(@Param("productname") String name,@Param("categoryid") Integer categoryid,
                                @Param("username") String username,
                                @Param("lowprice") BigDecimal low,@Param("highprice") BigDecimal high);
    List<Product> SearchProductById(@Param("sellerid")Integer id);
    Integer InsertProduct(@Param("product") Product product);
    Integer DeleteProduct(@Param("ProductId") Integer productid);
    Integer UpdateProduct(@Param("product") Product product);
    Integer getSellerId(@Param("productid") Integer productid);
}
