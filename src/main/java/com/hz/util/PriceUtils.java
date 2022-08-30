package com.hz.util;

import com.hz.pojo.Discount;
import com.hz.pojo.Discountactivity;
import com.hz.pojo.IDiscountactivity;

import java.math.BigDecimal;
import java.util.List;

public class PriceUtils {

    //获取单笔订单价格
    public static BigDecimal getOneCheapest(Discountactivity discountactivity,BigDecimal price){
        if(discountactivity.getDiscountId() == 0) return price;//单件原价
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(discountactivity.getDiscountPrice()));
        BigDecimal mul = bigDecimal.setScale(2);
        return price.multiply(mul);
    }

    //获取商家订单价格
    public static BigDecimal getSellerCheapest(List<Discountactivity> discountactivities,BigDecimal price) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        BigDecimal finalPrice = price;
        for (Discountactivity discountactivity : discountactivities) {
            if(price.compareTo(BigDecimal.valueOf(discountactivity.getDiscountCondition())) < 0) continue;
            Class<?> discount = Class.forName("com.hz.pojo.discountactivity."+Discount.style[discountactivity.getDiscountId()]);
            IDiscountactivity discountsyle = (IDiscountactivity) discount.newInstance();
            BigDecimal disprice = discountsyle.getPrice(price,discountactivity.getDiscountPrice());
            if(disprice.compareTo(finalPrice) < 0) finalPrice = disprice;
        }
        return finalPrice;
    }
}
