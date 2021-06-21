package com.shirodemo.demo;

import com.shirodemo.demo.pojo.Users;
import com.shirodemo.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        Users users = userService.queryUserByName("aaa");
        System.out.println(users);
    }

}
