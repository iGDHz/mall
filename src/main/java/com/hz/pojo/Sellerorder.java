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
public class Sellerorder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商家订单
     */
    @TableId(value = "SellerOrderId", type = IdType.AUTO)
    private Integer sellerOrderId;

    /**
     * 总订单id
     */
    private Integer totalOrderId;

    /**
     * 实付价格
     */
    private BigDecimal sellerOrderPrice;

    /**
     * 活动折扣
     */
    private Integer discountActivityid;




    public Integer getSellerOrderId() {
        return sellerOrderId;
    }

    public void setSellerOrderId(Integer sellerOrderId) {
        this.sellerOrderId = sellerOrderId;
    }
    public Integer getTotalOrderId() {
        return totalOrderId;
    }

    public void setTotalOrderId(Integer totalOrderId) {
        this.totalOrderId = totalOrderId;
    }
    public BigDecimal getSellerOrderPrice() {
        return sellerOrderPrice;
    }

    public void setSellerOrderPrice(BigDecimal sellerOrderPrice) {
        this.sellerOrderPrice = sellerOrderPrice;
    }
    public Integer getDiscountActivityid() {
        return discountActivityid;
    }

    public void setDiscountActivityid(Integer discountActivityid) {
        this.discountActivityid = discountActivityid;
    }

    @Override
    public String toString() {
        return "Sellerorder{" +
            "sellerOrderId=" + sellerOrderId +
            ", totalOrderId=" + totalOrderId +
            ", sellerOrderPrice=" + sellerOrderPrice +
            ", discountActivityid=" + discountActivityid +
        "}";
    }
}
