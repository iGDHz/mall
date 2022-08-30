package com.hz.pojo;

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
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 商家订单id
     */
    private Integer sellerOrderId;


    /**
     * 订单总价
     */
    private BigDecimal orderPrice;

    /**
     * 订单id
     */
    private Integer productId;

    /**
     * 商品数目
     */
    private Integer productNumber;

    /*
    * 订单状态
     */
   private Byte orderState;

   /*
   订单备注信息
    */
   private String orderRemark;


    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Byte getOrderState() {
        return orderState;
    }

    public void setOrderState(Byte orderState) {
        this.orderState = orderState;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getSellerOrderId() {
        return sellerOrderId;
    }

    public void setSellerOrderId(Integer sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
    }
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId=" + orderId +
            ", sellerOrderId=" + sellerOrderId +
            ", orderPrice=" + orderPrice +
            ", productId=" + productId +
            ", productNumber=" + productNumber +
        "}";
    }
}
