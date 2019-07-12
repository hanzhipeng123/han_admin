package com.han.adminlogin.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Auther: zhipeng.han@luckincoffee.com
 * @Date: 2019/7/12 15:33
 */
@RestController
@RequestMapping("/login")
public class LoginService {

    @RequestMapping("/index")
    public String toLogin(){
        return "index.html";
    }
}
