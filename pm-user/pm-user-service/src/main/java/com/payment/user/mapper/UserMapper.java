package com.payment.user.mapper;

import com.payment.user.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper{
    User selectUserInfoById(@Param(value="id") String id);
}
