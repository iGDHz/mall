package com.hz.service;

import com.hz.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public interface IProductService  {
    List<Product> SearchProduct(@Param("productname") String name, @Param("categoryid") Integer categoryid,
                                @Param("username") String username,
                                @Param("lowprice") BigDecimal low, @Param("highprice") BigDecimal high);
    List<Product> SearchProductById(@Param("sellerid")Integer id);
    boolean InsertProduct(@Param("Product") Product product);
    boolean DeleteProduct(@Param("ProductId") Integer productid);
    boolean UpdateProduct(@Param("Product") Product product);
    Integer getSellerId(@Param("productid") Integer productid);
}
