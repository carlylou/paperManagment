package com.paper.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by liumengyao on 17/4/25.
 */
@Controller
@RequestMapping("/papers")
public class PapersController {

    @RequestMapping("/add")
    public String addPaper(@RequestParam("paperPath") String paperPath){

        return "web_page_name";
    }

    @RequestMapping("/plan")
    public String addPaper(){

        return "web_page_name";
    }
}
