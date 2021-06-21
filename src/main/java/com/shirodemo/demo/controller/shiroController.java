package com.shirodemo.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
public class shiroController {

    @RequestMapping("/index")
    public String toIndex(Model model) {

        model.addAttribute("msg", "hello");
        return "index";
    }

    @RequestMapping("user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        token.setRememberMe(true);

        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg" , "用户名不存在");
            return "login";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }

    }

    @ResponseBody
    @RequestMapping("/notauth")
    public String unauthored() {
        return "未授权无法访问";
    }
}
