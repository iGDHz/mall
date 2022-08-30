package com.hz.service.impl;

import com.hz.pojo.Product;
import com.hz.mapper.ProductMapper;
import com.hz.service.IProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> SearchProduct(String name, Integer categoryid, String username,BigDecimal low, BigDecimal high) {
        return productMapper.SearchProduct(name,categoryid,username,low,high);
    }

    @Override
    public List<Product> SearchProductById(Integer id) {
        return productMapper.SearchProductById(id);
    }

    @Override
    public boolean InsertProduct(Product product) {
        return productMapper.InsertProduct(product)>0;
    }

    @Override
    public boolean DeleteProduct(@Param("ProductId") Integer productid) {
        return productMapper.DeleteProduct(productid)>0;
    }

    @Override
    public boolean UpdateProduct(Product product) {
        return productMapper.UpdateProduct(product)>0;
    }

    @Override
    public Integer getSellerId(Integer productid) {
        return productMapper.getSellerId(productid);
    }
}
