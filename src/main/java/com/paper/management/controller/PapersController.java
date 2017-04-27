package com.paper.management.controller;

import com.paper.management.entity.Papers;
import com.paper.management.service.PapersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liumengyao on 17/4/25.
 */
@Controller
@RequestMapping("/papers")
public class PapersController {
    @Autowired
    private PapersService papersService;

    @RequestMapping("/add")
    public String addPaper(@RequestParam("paperPath") String paperPath){

        return "web_page_name";
    }

    /**
     * 展示所有的Paper
     * @param model
     * @return 展示paper的视图
     */
    @RequestMapping("/allPaper")
    public String paperList(Model model){
        List<Papers> list = papersService.getAllPaper();
        /*list = new LinkedList<Papers>();
        Papers paper = new Papers();
        paper.setPaperName("SaNsde");
        list.add(paper);*/
        model.addAttribute("list",list);
        return "paper";
    }
    @RequestMapping("/plan")
    public String addPaper(){

        return "web_page_name";
    }
}
