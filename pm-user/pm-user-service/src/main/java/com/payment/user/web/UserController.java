package com.payment.user.web;

import com.payment.user.pojo.User;
import com.payment.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@RestController
@MapperScan("com.payment.user.mapper")
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping("test")
    public ResponseEntity<User> test(String id){
        return ResponseEntity.ok(userService.selectUserInfoById(id));
    }
}
