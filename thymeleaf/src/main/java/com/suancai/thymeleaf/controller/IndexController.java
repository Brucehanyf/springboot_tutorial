package com.suancai.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Bruce
 * @Date: 2020/3/15 15:20
 * @Description 首页控制器
 */
@Controller
public class IndexController {

//    @RequestMapping({"/","/index","index.html"})
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model){
        return "index";
    }
}