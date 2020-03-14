package com.suancai.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Bruce
 * @Date: 2020/3/3 22:43
 * @Description
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "thymeleaf")
                        String name) {
        request.setAttribute("name",name);
        return "hello";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
