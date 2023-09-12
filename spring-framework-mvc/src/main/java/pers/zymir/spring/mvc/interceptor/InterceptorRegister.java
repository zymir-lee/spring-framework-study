package pers.zymir.spring.mvc.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        // 注册拦截器，可以设置路径、执行顺序
        // /*能匹配/web /web1但是不能匹配 /web/demo
        // /** 可以匹配任意层级路径
        registry.addInterceptor(new WebInterceptor()).addPathPatterns("/**").order(0);
    }
}
