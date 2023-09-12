package pers.zymir.spring.mvc.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e) {
        log.info("发生了异常");
        return "error";
    }
}
