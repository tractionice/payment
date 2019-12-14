package com.payment.order.service;

import com.payment.common.enums.ExceptionEnums;
import com.payment.common.exception.PmException;
import com.payment.order.mapper.OrderMapper;
import com.payment.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Cacheable(value="redisCache",condition = "#result!='null'",key="'redis_user_'+#id")
    public Order queryOrder(int id){
        Order order = orderMapper.selectByPrimaryKey(id);
        if(order==null){
            throw new PmException(ExceptionEnums.ORDER_INFO_NOT_FOUND);
        }
        return order;
    }
}
