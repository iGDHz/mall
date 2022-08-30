package com.hz.config;

import com.hz.pojo.Discount;
import com.hz.pojo.Discountactivity;
import com.hz.service.IProductService;
import com.hz.service.impl.DiscountactivityServiceImpl;
import com.hz.service.impl.ProductServiceImpl;
import org.apache.ibatis.annotations.CacheNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
public class ActivityScheduleTask {

    @Autowired
    DiscountactivityServiceImpl discountactivityService;

    @Autowired
    ProductServiceImpl productService;

    @Scheduled(cron = "* * * * * *")
    public void UpdateActivity(){
        System.out.println(new Date());
    }
}
