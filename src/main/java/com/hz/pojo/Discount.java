package com.hz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public class Discount implements Serializable {
    public static String[] style={"OldPrice","MoneyOff","Discounted"};

    private static final long serialVersionUID = 1L;

    /**
     * 折扣方式id	
     */
    @TableId(value = "DiscountId", type = IdType.AUTO)
    private Integer discountId;

    /**
     * 折扣方式
     */
    private String discountStyle;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }
    public String getDiscountStyle() {
        return discountStyle;
    }

    public void setDiscountStyle(String discountStyle) {
        this.discountStyle = discountStyle;
    }

    @Override
    public String toString() {
        return "Discount{" +
            "discountId=" + discountId +
            ", discountStyle=" + discountStyle +
        "}";
    }
}
