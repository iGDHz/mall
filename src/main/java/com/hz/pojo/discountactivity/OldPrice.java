package com.hz.pojo.discountactivity;

import com.hz.pojo.IDiscountactivity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OldPrice implements IDiscountactivity {

    @Override
    public BigDecimal getPrice(BigDecimal price, BigDecimal discountPrice) {
        return price;
    }
}
