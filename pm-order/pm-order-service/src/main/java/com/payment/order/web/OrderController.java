package com.payment.order.web;

import com.payment.common.enums.ExceptionEnums;
import com.payment.common.exception.PmException;
import com.payment.common.utils.RedisUtil;
import com.payment.order.pojo.Order;
import com.payment.order.service.OrderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
@MapperScan("com.payment.order.mapper")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Resource
    private RedisUtil redis;

/*    @PostMapping
    public ResponseEntity<Order> serOrder(Order order){
        //校验价格
        if(order.getPrice()==null){
            throw new PmException(ExceptionEnums.PRICE_CAN_NOT_BE_NULL);
        }
        order = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(order);
    }*/
    @RequestMapping("queryOrder")
    public ResponseEntity<Order> queryOrderById(@RequestParam("id") int id){
        return ResponseEntity.ok(orderService.queryOrder(id));
    }
    @RequestMapping("qq123")
    public String testRedis(){
        redis.set("myindex","3323");
        String s = redis.get("myindex")+"";
        String m = redis.get("redis_user_1")+"";
        return "s="+s+",m="+m;
    }
    //发送mq
    @RequestMapping("sendMq")
    public String sendMq(){
        amqpTemplate.convertAndSend("payment.update","325346436");
        return "2352345432";
    }
}
