package com.hz.controller.pojocontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hz.controller.BaseController;
import com.hz.pojo.Discountactivity;
import com.hz.service.impl.DiscountactivityServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.Mergeable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@RestController
public class DiscountactivityController extends BaseController {

    @Autowired
    DiscountactivityServiceImpl discountactivityService;

    @RequestMapping(value = "/discountactivity",method = RequestMethod.POST)
    public String getdiscount(@RequestParam(value = "DiscountActivityId",required = false) Integer discountactivityId,
                              @RequestParam(value = "UserId",required = false) Integer userId){
        JSONObject json = new JSONObject();

        Discountactivity discount = discountactivityService.getDiscount(discountactivityId);
        json.put("DiscountId",discount.getDiscountId());
        json.put("DiscountCondition",discount.getDiscountCondition());
        json.put("DiscountDetail",discount.getDiscountDeatil());
        json.put("DiscountPrice",discount.getDiscountPrice());
        json.put("ActivityStartTime",discount.getActivityStartTime());
        json.put("ActivityEndTime",discount.getActivityEndTime());
        json.put("UserId",userId);
        logger.info("获取打折信息");
        return json.toJSONString();
    }

    @RequestMapping(value = "/seller/setdiscount",method = RequestMethod.POST)
    public String addDiscount(@RequestParam("DiscountId")Integer DisId,
                              @RequestParam("DiscountCondition")Integer DCondition,
                              @RequestParam("DiscountDetail")String DDL,
                              @RequestParam("ActivityStartTime") Date start,
                              @RequestParam("ActivityEndTime")Date end){
        JSONObject message = new JSONObject();
        Discountactivity discountactivity = new Discountactivity();
        discountactivity.setDiscountId(DisId);
        discountactivity.setDiscountCondition(DCondition);
        discountactivity.setDiscountDeatil(DDL);
        discountactivity.setActivityStartTime(start);
        discountactivity.setActivityEndTime(end);

        if (discountactivityService.InsertDiscount(discountactivity)) return JSON.toJSONString(discountactivity);
        else  return JSON.toJSONString(null);
    }
}
