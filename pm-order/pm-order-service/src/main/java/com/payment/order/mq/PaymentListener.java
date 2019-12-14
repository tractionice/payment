package com.payment.order.mq;

import com.payment.common.enums.ExceptionEnums;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name="search.payment.insert.queue", durable = "true"),
            exchange = @Exchange(name = "pm.item.exchange", type = ExchangeTypes.TOPIC),
            key = {"payment.update"}
    ))
    public void listenUpdate(String id){
        if(id==null){
            return;
        }else{
            System.out.println("消费id："+id);
        }
    }

}
