package com.paper.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liumengyao on 17/4/19.
 */
@Controller
@RequestMapping("/")
public class Hello {

    @RequestMapping("hello")
    public String two(HttpServletRequest request, Model model){
        String s = "check controller Hello for details!";
        model.addAttribute("welcome", s);
        return "hello";
    }
}
