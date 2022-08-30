package com.hz.controller.pojocontroller;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hz.pojo.Order;
import com.hz.pojo.Sellerorder;
import com.hz.pojo.Totalorder;
import com.hz.pojo.User;
import com.hz.service.impl.*;
import com.hz.util.PriceUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hz
 * @since 2022-03-15
 */
@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    DiscountactivityServiceImpl discountactivityService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    SellerorderServiceImpl sellerorderService;
    @Autowired
    TotalorderServiceImpl totalorderService;

    @RequestMapping(value = "/user/addorder",method = RequestMethod.POST)
    public String CreateOrder(HttpSession session, @RequestBody Map<String, Object> orders) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        HashMap<Integer, List> sellers = new HashMap<>();//存储商家信息
        String address = (String) orders.get("address"); //获取地址编号
        String addressdetail = (String) orders.get("addressdetail");//获取详细地址
        User user = (User) session.getAttribute("user");//获取用户信息
        JSONObject[] ordersArray = (JSONObject[])orders.get("orders");//获取订单信息
        JSONObject totalorders = new JSONObject();
        List<Order> list = new ArrayList<>();
        for (JSONObject jsonObject : ordersArray) {
            BigDecimal price = (BigDecimal) jsonObject.get("orderPrice");//获取商品原价
            Integer productId = (Integer) jsonObject.get("productId");//获取商品Id
            Integer number = jsonObject.getInteger("productNumber");//获取商品数量
            String remark = jsonObject.getString("OrderRemark");//获取订单备注信息
            Integer DAId = jsonObject.getInteger("discountActivityId");//获取打折信息

            Order orderT = new Order();
            orderT.setOrderPrice(PriceUtils.getOneCheapest(discountactivityService.getDiscount(DAId),price));
            orderT.setProductId(productId);
            orderT.setOrderState((byte) 0);
            orderT.setOrderRemark(remark);
            orderT.setProductNumber(number);
            Integer sellerid = productService.getSellerId(productId);//获取商品所属商家ID
            /*
            * sellerorderId未设置
            * */
            List<Order> Sorder = sellers.getOrDefault(sellerid,new ArrayList());
            Sorder.add(orderT);
            if(Sorder.size() == 1){
                sellers.put(sellerid,Sorder);
            }
            list.add(orderT);
        }

        //sellerorder
        Set<Map.Entry<Integer, List>> entrySet = sellers.entrySet();
        List<Sellerorder> sellerorders = new ArrayList<>();
        for (Map.Entry<Integer, List> entry : entrySet) {
            Sellerorder sellerorder = new Sellerorder();
            List<Order> o = entry.getValue();
            BigDecimal price = new BigDecimal(0);
            for (Order order : o) {
                price = price.add(order.getOrderPrice());
            }
            price = PriceUtils.getSellerCheapest(discountactivityService.getDiscounts(entry.getKey()),price);
            sellerorder.setSellerOrderPrice(price);
            sellerorders.add(sellerorder);
        }

        //totalorder
        Totalorder totalorder = new Totalorder();
        totalorder.setOrderAddress(address);
        totalorder.setOrderAddressDetail(addressdetail);
        BigDecimal totalprice = new BigDecimal(0);
        for (Sellerorder sellerorder : sellerorders) {
            totalprice = totalprice.add(sellerorder.getSellerOrderPrice());
        }
        totalprice = PriceUtils.getSellerCheapest(discountactivityService.getDiscounts(-1),totalprice);
        totalorder.setTotalOrderPrice(totalprice);
        totalorder.setUserId(user.getUserId());
        totalorderService.InsertTotalOrder(totalorder);

        //totalorder
        totalorders.put("TotalORderId",totalorder.getTotalOrderId());
        totalorders.put("OrderAddress",address);
        totalorders.put("OrderAddressDetail",addressdetail);
        totalorders.put("TotalOrderPrice",totalprice);


        //sellerorder - json
        JSONArray second = new JSONArray();
        entrySet = sellers.entrySet();
        int index = 0;
        for (Map.Entry<Integer, List> entry : entrySet) {
            JSONObject object = new JSONObject();
            Integer key = entry.getKey();
            Sellerorder sellerorder = sellerorders.get(index);
            sellerorder.setTotalOrderId(totalorder.getTotalOrderId());
            sellerorderService.InsertSellerOrder(sellerorder);
            index++;

            JSONArray third = new JSONArray();
            List<Order> o = entry.getValue();
            for (Order order : o) {
                order.setSellerOrderId(sellerorder.getSellerOrderId());
                orderService.InsertOne(order);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("sellerOrderId",sellerorder.getSellerOrderId());
                jsonObject.put("orderPrice",order.getOrderPrice());
                jsonObject.put("productId",order.getOrderId());
                jsonObject.put("productNumber",order.getProductNumber());
                jsonObject.put("orderState",0);
                third.add(jsonObject);
            }

            object.put("orders",third);
            object.put("SellerOrderId",sellerorder.getSellerOrderId());
            object.put("TotalOrderId",totalorder.getTotalOrderId());
            object.put("SellerOrderPrice",sellerorder.getSellerOrderPrice());
            second.add(object);
        }
        totalorders.put("TotalOrder",second);
        sellerorderService.InsertSellerOrders(sellerorders);
        return totalorders.toJSONString();
    }

    @RequestMapping(value = "/updateorder",method = RequestMethod.POST)
    public String updateOrder(@RequestParam("orderid")Integer id,@RequestParam("orderState") Integer status){
        JSONObject msg = new JSONObject();
        orderService.updateOrder(id,status);
        msg.put("message","ok");
        return msg.toJSONString();
    }
}
