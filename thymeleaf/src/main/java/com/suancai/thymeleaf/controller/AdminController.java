package com.suancai.thymeleaf.controller;

import com.suancai.thymeleaf.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Author Bruce
 * @Date: 2020/3/14 23:00
 * @Description 用户控制器
 */
@Controller
@Slf4j
public class AdminController {

    /**
     * 跳转登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    /**
     * 用户登录
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(UserDto user, HttpSession session) {
        log.info(user.getUserName() + ":" + user.getPassword());
        session.setAttribute("user", user);
        return "redirect:index";
    }
}