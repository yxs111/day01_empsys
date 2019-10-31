package com.qfedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/6/6.
 */
@Controller
public class UserController {
    @RequestMapping("/login.do")
    public String login(String username,String password){
         return null;
    }
}
