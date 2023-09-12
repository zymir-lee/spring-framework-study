package pers.zymir.spring.mvc.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 注册为rest controller bean, body通过JSON序列化方式返回
@RestController
// URL路径前缀
@RequestMapping("/web")
@Slf4j
public class WebController {

    // 基本都存在defaultValue、required参数表示默认值、以及是否必须
    @GetMapping
    public String get(@RequestParam(value = "param", defaultValue = "value", required = false) String param,
                      @CookieValue("token") String token,
                      @RequestHeader("header") String header) {
        log.info("请求参数获取:{}", param);
        log.info("http cookie获取:{}", token);
        log.info("http header获取:{}", header);
        return "OK";
    }

    @GetMapping("/{param}")
    public void pathParam(@PathVariable("param") String param) {
        log.info("URL路径参数获取:{}", param);
    }

    @PostMapping
    public void post(@RequestBody Req req) {
        log.info("post请求获取body内容: {}", req);
    }

    @GetMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 接口获取httpRequest httpResponse对象
        // request对象用来获取请求报文内容
        // response对象用来写入响应报文内容 例如状态码等
    }

    @Data
    public static class Req {
        private Long id;
        private String name;
    }
}
