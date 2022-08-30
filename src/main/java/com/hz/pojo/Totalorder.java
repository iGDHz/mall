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
public class Totalorder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总订单id
     */
    @TableId(value = "TotalOrderId", type = IdType.AUTO)
    private Integer totalOrderId;

    /**
     * 订单区号地址
     */
    private String orderAddress;

    /**
     * 订单详细地址
     */
    private String orderAddressDetail;

    /**
     * 折扣信息
     */
    private Integer discountActivityId;

    /**
     * 总订单价格
     */
    private BigDecimal totalOrderPrice;

    /**
     * 用户id
     */
    private Integer userId;

    public Integer getTotalOrderId() {
        return totalOrderId;
    }

    public void setTotalOrderId(Integer totalOrderId) {
        this.totalOrderId = totalOrderId;
    }
    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }
    public String getOrderAddressDetail() {
        return orderAddressDetail;
    }

    public void setOrderAddressDetail(String orderAddressDetail) {
        this.orderAddressDetail = orderAddressDetail;
    }
    public Integer getDiscountActivityId() {
        return discountActivityId;
    }

    public void setDiscountActivityId(Integer discountActivityId) {
        this.discountActivityId = discountActivityId;
    }
    public BigDecimal getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(BigDecimal totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Totalorder{" +
            "totalOrderId=" + totalOrderId +
            ", orderAddress=" + orderAddress +
            ", orderAddressDetail=" + orderAddressDetail +
            ", discountActivityId=" + discountActivityId +
            ", totalOrderPrice=" + totalOrderPrice +
            ", userId=" + userId +
        "}";
    }
}
