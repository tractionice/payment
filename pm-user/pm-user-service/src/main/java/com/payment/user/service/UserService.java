package com.payment.user.service;

import com.payment.user.mapper.UserMapper;
import com.payment.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Cacheable(value="redisCache",condition = "#result!='null'",key="'redis_user_'+#id")
    public User selectUserInfoById(String id){
        return userMapper.selectUserInfoById(id);
    };


}
