package com.hz;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.hz.pojo.*;
import com.hz.service.impl.*;
import com.hz.util.DateUtil;
import com.hz.util.Md5Utils;
import com.hz.util.SpringContextUtil;
import org.apache.catalina.core.ApplicationContext;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@SpringBootTest
class MallApplicationTests {
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    CommentServiceImpl commentService;
    @Autowired
    DiscountactivityServiceImpl discountactivityService;
    @Autowired
    DiscountServiceImpl discountService;
    @Autowired
    OrderServiceImpl orderService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    SellerorderServiceImpl sellerorderService;
    @Autowired
    TotalorderServiceImpl totalorderService;
    @Autowired
    UserServiceImpl userService;

    Random random = new Random(System.currentTimeMillis());
    @Test
    public void usertest(){
        User user = new User();
        user.setUserNickname("chz");
        user.setUserPassword(Md5Utils.md5("12345"));

        Random random = new Random(System.currentTimeMillis());
        UUID uuid = UUID.randomUUID();
        user.setUserName("cpx"+ uuid.toString().substring(0,10));
        List<Address> province = addressService.SearchProvince();
        List<Address> xian = addressService.SearchByName(province.get(random.nextInt(province.size())).getAddressName());
        user.setUserAddress(addressService.SearchByName(xian.get(random.nextInt(xian.size())).getAddressName()).get(random.nextInt(1)).getAddressAreaId());
        user.setUserRoleId(random.nextInt(10)%2+2);
        userService.InsertUser(user);
//        User cpx = userService.SelectByUsername("cpx", 1);
//        user.setUserId(cpx.getUserId());
//        userService.UpdateUser(user);
    }

    @Test
    public void productTest(){
//        for (int i = 0; i < 20; i++) {
//            Product product = new Product();
//            UUID uuid = UUID.randomUUID();
//            List<Category> category = categoryService.getCategory();
//            Random random = new Random(System.currentTimeMillis());
//            product.setCategoryId(category.get(random.nextInt(category.size())).getCategoryId());
//            product.setUserId(9);
//            product.setProductName("商品"+uuid.toString().substring(0,10));
//            product.setProductBrief("商品简介");
//            product.setProductDetail("商品详情");
//            product.setProductPrice(new BigDecimal(new Random(System.currentTimeMillis()).nextInt(100)).setScale(2, RoundingMode.HALF_DOWN));
//            product.setDiscountActivityId(0);
//            product.setProductPictureFirst(uuid.toString()+".jpg");
//            product.setProductRepertory(10);
//            product.setProductSold(0);
//
//            productService.InsertProduct(product);
//        }

        List<Product> products = productService.SearchProduct(null,-1,null,null,null);
        for (Product product : products) {
            System.out.println(product);
        }
        Product product = products.get(new Random().nextInt(products.size()));
        Product product1 = new Product();
        product1.setProductId(product.getProductId());
        product1.setProductPrice(new BigDecimal(10.00).setScale(2,RoundingMode.HALF_DOWN));

        productService.UpdateProduct(product1);
    }


    @Test
    public void TestDiscountActivity() throws ParseException {
        Discountactivity discountactivity = new Discountactivity();
        discountactivity.setDiscountId(0);
        discountactivity.setDiscountCondition(100);
        discountactivity.setDiscountDeatil("开店优惠");
        discountactivity.setActivityStartTime(DateUtil.getDate("2022-1-11 00:00:00"));
        discountactivity.setActivityEndTime(DateUtil.getDate("2022-1-11 23:59:59"));
        discountactivity.setDiscountPrice(new BigDecimal("10").setScale(2,RoundingMode.HALF_DOWN));
        discountactivity.setUserId(1);
        discountactivityService.InsertDiscount(discountactivity);
        System.out.println(discountactivity);
        discountactivityService.UpdateDiscount(discountactivity);
        List<Discountactivity> discounts = discountactivityService.getDiscounts(1);
        for (Discountactivity discount : discounts) {
            System.out.println(discount);
        }
        discountactivityService.DeleteDiscount(discountactivity.getDiscountActivityId());
    }

    @Test
    public void Testcomment(){
        Comment comment = new Comment();
        comment.setCommentDetail("质量好");
        comment.setProductId(random.nextInt(10));
        comment.setCommentPraise(random.nextInt(10));
        comment.setCommentReturnId(random.nextInt(10));
        commentService.InsertComment(comment);

        List<Comment> comment1 = commentService.getComment(comment.getProductId());
        for (Comment comment2 : comment1) {
            System.out.println(comment2);
        }

        commentService.updateComment(comment);

        commentService.deleteComment(comment.getCommentId());
    }

    @Test
    public void TesrOrder(){
        ArrayList<Order> orders = new ArrayList<>();
        int one = random.nextInt(20);
        Order InsertOrder = null;
        for (int i = 0; i < 20; i++) {
            Order order = new Order();
            order.setSellerOrderId(random.nextInt(10));
            order.setOrderPrice(new BigDecimal(random.nextInt(1000000)).setScale(2,RoundingMode.HALF_DOWN));
            order.setProductId(random.nextInt(10));
            order.setProductNumber(random.nextInt(5));
            order.setOrderState((byte) random.nextInt(3));
            order.setOrderRemark("快递");
            if(i == one) {
                InsertOrder = order;
                orderService.InsertOne(order);
            }
            else orders.add(order);
        }
        orderService.InsertOrders(orders);
        orderService.updateOrder(InsertOrder.getOrderId(),2);
        System.out.println(InsertOrder);
        System.out.println("======================================");
        List<Order> orders1 = orderService.getOrders(9);
        for (Order order : orders1) {
            System.out.println(order);
        }

    }

    @Test
    public void SellerOrdertest(){
        ArrayList<Sellerorder> sellerorders = new ArrayList<>();
        int choice = random.nextInt(20);
        for (int i = 0; i < 20; i++) {

            Sellerorder sellerorder = new Sellerorder();
            sellerorder.setTotalOrderId(random.nextInt(20));
            sellerorder.setSellerOrderPrice(new BigDecimal(random.nextInt(10000)).setScale(2,RoundingMode.HALF_DOWN));
            sellerorder.setDiscountActivityid(random.nextInt(10));
            if(choice == i) {
                sellerorderService.InsertSellerOrder(sellerorder);
                System.out.println("==========================================================");
                System.out.println(sellerorder);
                System.out.println("==========================================================");
            }else sellerorders.add(sellerorder);
        }
        sellerorderService.InsertSellerOrders(sellerorders);
        List<Sellerorder> orders = sellerorderService.getOrders(sellerorders.get(random.nextInt(sellerorders.size())).getSellerOrderId());
        for (Sellerorder order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void testTotalOrder(){
        int choice = random.nextInt(20);
        List<Address> addressList = addressService.SearchProvince();
        List<Address> addressList1 = addressService.SearchByName(addressList.get(random.nextInt(addressList.size())).getAddressName());


        for (int i = 0; i < 20; i++) {
            Totalorder totalorder = new Totalorder();
            totalorder.setUserId(9);
            List<Address> address = addressService.SearchByName(addressList1.get(random.nextInt(addressList1.size())).getAddressName());
            totalorder.setOrderAddress(address.get(random.nextInt(address.size())).getAddressAreaId());
            totalorder.setOrderAddressDetail("某村");
            totalorder.setDiscountActivityId(random.nextInt(20));
            totalorder.setTotalOrderPrice(new BigDecimal(random.nextInt(100000000)).setScale(2,RoundingMode.HALF_DOWN));
            totalorder.setUserId(9);
            totalorderService.InsertTotalOrder(totalorder);
            if(choice == i){
                Totalorder totalOrder = totalorderService.getTotalOrder(totalorder.getUserId());
                System.out.println(totalOrder);
            }
        }

    }

    @Test
    public void testrandom(){
        UUID uuid = UUID.randomUUID();
        Set<String> set = new HashSet<>();
        int i = 0;
        while(!set.contains(uuid)){
            set.add(uuid.toString());
            uuid = UUID.randomUUID();
            i++;
            if(i%10000 == 0) System.out.println(i/10000);
        }
    }

}
