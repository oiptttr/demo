package com.shirodemo.demo.mapper;

import com.shirodemo.demo.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface UserMapper {

    public Users queryUserByName(String name);


}
