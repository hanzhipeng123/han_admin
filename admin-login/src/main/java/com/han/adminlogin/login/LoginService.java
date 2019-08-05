package com.han.adminlogin.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: TODO
 * @Auther: zhipeng.han@luckincoffee.com
 * @Date: 2019/7/12 15:33
 */
@Controller
@RequestMapping("/login")
public class LoginService {

    @RequestMapping("/index")
    public String toLogin(){
        return "index";
    }
}
