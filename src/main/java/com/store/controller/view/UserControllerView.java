package com.store.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 作者：MaWeiZe
 * 2021/4/16
 */
@Controller
public class UserControllerView {

    /**
     * 跳转到登录页
     * @return 登录页
     */
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/login")
    public String login(){
        return "index copy";
    }
}
