package com.baizhi.controller;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Log4j
@Controller
@RequestMapping("/user")
public class Usercontroller {
    @RequestMapping("/loginuser")
    public String Loginuser(String userName,String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
            return "index";
            }
        catch (UnknownAccountException e) {
            e.printStackTrace();
            log.info("账号错误");
            return "/commmon/login";
        }
        catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            log.info("密码错误");
            return "/commmon/login";
        }


    }
    @RequestMapping("/loginout")
    public String loginout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/commmon/login";
    }
}
