package com.suancai.thymeleaf.controller;

import com.suancai.thymeleaf.common.CommonResponse;
import com.suancai.thymeleaf.dto.UserDto;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Getter;
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

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public String register(){
        return "admin/register";
    }

    /**
     * 注册用户
     * @param userDto
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public CommonResponse register(UserDto userDto){
        return CommonResponse.ok();
    }

    /**
     * 退出登录
     * @param userName
     * @param session
     * @return
     */
    @PostMapping("/logout")
    public String logout(String userName, HttpSession session) {
        log.info(userName + "logout...");
        session.removeAttribute("user");
        return "redirect:logint";
    }
}