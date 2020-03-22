package com.suancai.thymeleaf.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author Bruce
 * @Date: 2020/3/22 8:08
 * @Description 核心处理类
 */
@Configuration
public class CoreWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // index.html -> index
        configurer.setUseRegisteredSuffixPatternMatch(true)
                .setUseSuffixPatternMatch(true);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 页面登录拦截
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns("/")
                .excludePathPatterns("/index")
                .excludePathPatterns("/login")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/contact")
                .excludePathPatterns("/register")
                .excludePathPatterns("/static/**");
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /* 将 /请求映射给index **/
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 配置资源映射 等同于
         * #  mvc:
         * #    static-path-pattern: /static/** # 添加静态文件过滤
         */
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("*.html")
                .addResourceLocations("/*");
    }
}
