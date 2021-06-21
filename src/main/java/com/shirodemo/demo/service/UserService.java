package com.shirodemo.demo.service;

import com.shirodemo.demo.mapper.UserMapper;
import com.shirodemo.demo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Users queryUserByName(String name) {
        Users aaa = userMapper.queryUserByName(name);
        return aaa;
    }

}
