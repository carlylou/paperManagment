package com.paper.management.controller;

import com.paper.management.entity.Author;
import com.paper.management.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liumengyao on 17/4/20.
 */
@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @RequestMapping("")
    public String query(){
        return "query";
    }

    @RequestMapping("/name")
    public String showByName(HttpServletRequest request, @RequestParam("authorName") String authorName, Model model){
        Author author = authorService.getByName(authorName);
        model.addAttribute("authorName", author.getAuthorName());
        model.addAttribute("contact", author.getContact());
        model.addAttribute("comment", author.getComment());
        return "author";
    }
}
