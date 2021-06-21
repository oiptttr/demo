package com.shirodemo.demo.config;

import com.shirodemo.demo.pojo.Users;
import com.shirodemo.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Administrator
 */ 
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");
        info.addStringPermission("user:update");
        Subject subject = SecurityUtils.getSubject();
        Users currentUser = (Users) subject.getPrincipal();

        info.addStringPermission(currentUser.getPerms());

        System.out.println("执行了授权");
        System.out.println("git提交");
        System.out.println("git提交 hot");
        System.out.println("git提交 cool");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

//        String username = "123";
//        String password = "123";
        System.out.println("执行了认证");


        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        Users users = userService.queryUserByName(usernamePasswordToken.getUsername());
        if(users == null) {
            return null;
        }


        return new SimpleAuthenticationInfo(users, users.getPassword(), "");
    }
}
