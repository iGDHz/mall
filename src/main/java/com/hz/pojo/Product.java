package com.hz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "ProductId", type = IdType.AUTO)
    private Integer productId;

    /**
     * 商品所属分类id
     */
    private Integer categoryId;

    /*
        所诉商家id
     */
    private Integer userId;

    /**
     * 商品名
     */
    private String productName;

    /**
     * 商品简介
     */
    private String productBrief;

    /**
     * 商品详情
     */
    private String productDetail;

    /**
     * 商品售价
     */
    private BigDecimal productPrice;

    /**
     * 折扣活动
     */
    private Integer discountActivityId;

    /**
     * 商品展示图
     */
    private String productPictureFirst;

    /**
     * 商品图集
     */
    private String productPictureTotal;

    /**
     * 商品库存
     */
    private Integer productRepertory;

    /**
     * 商品已售
     */
    private Integer productSold;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductBrief() {
        return productBrief;
    }

    public void setProductBrief(String productBrief) {
        this.productBrief = productBrief;
    }
    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
    public Integer getDiscountActivityId() {
        return discountActivityId;
    }

    public void setDiscountActivityId(Integer discountActivityId) {
        this.discountActivityId = discountActivityId;
    }
    public String getProductPictureFirst() {
        return productPictureFirst;
    }

    public void setProductPictureFirst(String productPictureFirst) {
        this.productPictureFirst = productPictureFirst;
    }
    public String getProductPictureTotal() {
        return productPictureTotal;
    }

    public void setProductPictureTotal(String productPictureTotal) {
        this.productPictureTotal = productPictureTotal;
    }
    public Integer getProductRepertory() {
        return productRepertory;
    }

    public void setProductRepertory(Integer productRepertory) {
        this.productRepertory = productRepertory;
    }
    public Integer getProductSold() {
        return productSold;
    }

    public void setProductSold(Integer productSold) {
        this.productSold = productSold;
    }

    @Override
    public String toString() {
        return "Product{" +
            "productId=" + productId +
            ", categoryId=" + categoryId +
            ", productName=" + productName +
            ", productBrief=" + productBrief +
            ", productDetail=" + productDetail +
            ", productPrice=" + productPrice +
            ", discountActivityId=" + discountActivityId +
            ", productPictureFirst=" + productPictureFirst +
            ", productPictureTotal=" + productPictureTotal +
            ", productRepertory=" + productRepertory +
            ", productSold=" + productSold +
        "}";
    }
}
