package com.bangduoduo.monkey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {
    @RequestMapping("/home/hello")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }
}
