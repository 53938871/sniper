package com.bangduoduo.web.controller;

import com.bangduoduo.web.domain.User;
import com.bangduoduo.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/demo")
    public String demo() {
        User user = userService.getUserById(1);
        System.out.println(user.getPassword());
        return "demo";
    }
}
