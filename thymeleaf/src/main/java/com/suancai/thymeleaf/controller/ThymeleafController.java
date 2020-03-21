package com.suancai.thymeleaf.controller;

import com.suancai.thymeleaf.dto.UserDto;
import com.suancai.thymeleaf.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Bruce
 * @Date: 2020/3/15 21:08
 * @Description thymeleaf测试controller
 */
@Controller
public class ThymeleafController {
    /***
     * thymeleaf demo
     * @param modelAndView
     * @return
     */
    @RequestMapping("/thymeleaf")
    public ModelAndView thymeleaf(ModelAndView modelAndView) {
        modelAndView.setViewName("/thymeleaf");
        UserDto dto = new UserDto();
        dto.setUserName("Bruce");
        dto.setPassword("123456");
        dto.setVarifyCode("12306");
        modelAndView.addObject("user", dto);
        modelAndView.addObject("html","<h1>我是H1</h1>");
        modelAndView.addObject("flag",true);

        List<UserDto> list = new ArrayList<>();
        UserDto userDto;
        for (int i = 0; i <10 ; i++) {
            userDto = new UserDto();
            userDto.setUserName((i+1)+"Bruce");
            userDto.setPassword(UUID.randomUUID().toString());
            userDto.setVarifyCode(String.valueOf(i));
            list.add(userDto);
        }
        modelAndView.addObject("list",list);
        return modelAndView;
    }
}
