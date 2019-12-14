package com.payment.order.mapper;

import com.payment.order.pojo.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface OrderMapper extends Mapper<Order> {
}
