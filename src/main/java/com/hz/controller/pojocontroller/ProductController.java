package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hz.controller.BaseController;
import com.hz.pojo.Product;
import com.hz.service.impl.ProductServiceImpl;
import com.hz.util.FileOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@RestController
public abstract class ProductController extends BaseController {
    @Autowired
    ProductServiceImpl productService;

    @RequestMapping(value = "/product/get",method = RequestMethod.POST )
    public String getProduct(@RequestParam(value = "productname",required = false) String productname,
                             @RequestParam(value = "categoryid",required = false) Integer categoryid,
                             @RequestParam(value = "username",required = true) String sellername,
                             @RequestParam(value = "lowprice",required = false)String low,
                             @RequestParam(value = "highprice",required = false)String high){
        JSONObject products = new JSONObject();
        BigDecimal lowPrice = null;
        BigDecimal highPrice = null;
        productname = productname.replace("%", "");
        if(productname != null) productname = "%"+productname+"%";
        if(low != null) lowPrice = new BigDecimal(low);
        if(high != null) highPrice = new BigDecimal(high);
        List<Product> productList = productService.SearchProduct(productname,categoryid,sellername,lowPrice,highPrice);
        JSONArray array = new JSONArray();
        //添加商品信息
        for (Product product : productList) {
            JSONObject jproduct = new JSONObject();
            jproduct.put("productId",product.getProductId());
            jproduct.put("categoryId",product.getCategoryId());
            jproduct.put("userId",product.getUserId());
            jproduct.put("productName",product.getProductName());
            jproduct.put("productBrief",product.getProductBrief());
            jproduct.put("productDetail",product.getProductDetail());
            jproduct.put("productPrice",product.getProductPrice());
            jproduct.put("discountActivityId",product.getDiscountActivityId());
            jproduct.put("productPictureFirst",product.getProductPictureFirst());
            JSONArray productPT = new JSONArray();
            if(product.getProductPictureTotal() != null) {
                String[] picture = product.getProductPictureTotal().split(";");
                for (String s : picture) {
                    productPT.add(s);
                }
            }
            jproduct.put("productPictureTotal",productPT);
            jproduct.put("productRepertory",product.getProductRepertory());
            jproduct.put("productSold",product.getProductSold());
            array.add(jproduct);
        }
        products.put("product",array);
        logger.info("获取商品信息");
        return products.toJSONString();
    }

    @RequestMapping(value = "/seller/addproduct",method = RequestMethod.POST)
    public String addProduct(HttpSession session,
                            @RequestParam("CategoryId") Integer categoryid,
                             @RequestParam("ProductName") String productname,
                             @RequestParam("ProductBrief") String productBrief,
                             @RequestParam("ProductDetail") String productDetail,
                             @RequestParam("ProductPrice") String productPrice,
                             @RequestParam("DiscountActivityId") Integer DisAtId,
                             @RequestParam("ProductPictureFirst") String PPF,
                             @RequestParam("ProductPictureTotal") String PPT,
                             @RequestParam("ProductRepertory") Integer PRepertory,
                             @RequestParam("ProductSold") Integer soled){
        Product product = new Product();
        product.setCategoryId(categoryid);
        product.setProductName(productname);
        product.setProductBrief(productBrief);
        product.setProductDetail(productDetail);
        product.setProductPrice(new BigDecimal(productPrice));
        product.setDiscountActivityId(DisAtId);

        FileOperation.uploadImage(session,PPF);
        product.setProductPictureFirst(PPF);
        String[] split = PPT.split(";");
        for (String s : split) {
            FileOperation.uploadImage(session,s);
        }
        product.setProductPictureTotal(PPT);
        product.setProductRepertory(PRepertory);
        product.setProductSold(soled);
        JSONObject msg = new JSONObject();
        if(productService.InsertProduct(product)){
            msg.put("message","商品添加成功");
        }else msg.put("message","商品添加失败");
        logger.info(msg.toJSONString());
        return msg.toJSONString();
    }

    @RequestMapping(value = "/seller/deleteproduct",method = RequestMethod.POST)
    public String deleteproduct(@RequestParam("productid") Integer productid){
        productService.DeleteProduct(productid);
        JSONObject message = new JSONObject();
        message.put("message","商品删除成功");
        return  message.toJSONString();
    }

    @RequestMapping(value = "seller/updateproduct",method = RequestMethod.POST)
    public String updateproduct(HttpSession session,
                                @RequestParam(value = "flag") Integer flag,
                                @RequestParam(value = "productid") Integer productid,
                                @RequestParam(value = "CategoryId" ,required = false) Integer categoryid,
                                @RequestParam(value = "ProductName",required = false) String productname,
                                @RequestParam(value = "ProductBrief",required = false) String productBrief,
                                @RequestParam(value = "ProductDetail",required = false) String productDetail,
                                @RequestParam(value = "ProductPrice",required = false) String productPrice,
                                @RequestParam(value = "DiscountActivityId",required = false) Integer DisAtId,
                                @RequestParam(value = "ProductPictureFirst",required = false) String PPF,
                                @RequestParam(value = "ProductPictureTotal",required = false) String PPT,
                                @RequestParam(value = "ProductRepertory",required = false) Integer PRepertory,
                                @RequestParam(value = "ProductSold",required = false) Integer soled){
        JSONObject message = new JSONObject();
        Product product = new Product();
        product.setProductId(productid);
        product.setCategoryId(categoryid);
        product.setProductName(productname);
        product.setProductBrief(productBrief);
        product.setProductDetail(productDetail);
        product.setProductPrice(new BigDecimal(productPrice));
        product.setDiscountActivityId(DisAtId);
        product.setProductPictureFirst(PPF);
        product.setProductPictureTotal(PPT);
        product.setProductRepertory(PRepertory);
        product.setProductSold(soled);
        if(productService.UpdateProduct(product))
        message.put("message","更新成功");
        else message.put("message","更新失败");
        logger.info(message.toJSONString());
        return message.toJSONString();
    }
}
