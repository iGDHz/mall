package com.hz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
public class Discountactivity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 折扣活动
     */
    @TableId(value = "DiscountActivityId", type = IdType.AUTO)
    private Integer discountActivityId;

    /**
     * 折扣id
     */
    private Integer discountId;

    /**
     * 达到折扣条件
     */
    private Integer discountCondition;

    /**
     * 折扣信息
     */
    private String discountDetail;

    /**
     * 活动开始时间
     */
    private Date activityStartTime;

    /**
     * 活动结束时间
     */
    private Date activityEndTime;

    /*
        优惠价格
     */
    private BigDecimal discountPrice;

    /*
        用户id
     */
    private Integer userId;

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDiscountActivityId() {
        return discountActivityId;
    }

    public void setDiscountActivityId(Integer discountActivityId) {
        this.discountActivityId = discountActivityId;
    }
    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }
    public Integer getDiscountCondition() {
        return discountCondition;
    }

    public void setDiscountCondition(Integer discountCondition) {
        this.discountCondition = discountCondition;
    }

    public String getDiscountDeatil() {
        return discountDetail;
    }

    public void setDiscountDeatil(String discountDeatil) {
        this.discountDetail = discountDeatil;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    @Override
    public String toString() {
        return "Discountactivity{" +
            "discountActivityId=" + discountActivityId +
            ", discountId=" + discountId +
            ", discountCondition=" + discountCondition +
            ", discountDeatil=" + discountDetail +
            ", activityStartTime=" + activityStartTime +
            ", activityEndTime=" + activityEndTime +
        "}";
    }
}
