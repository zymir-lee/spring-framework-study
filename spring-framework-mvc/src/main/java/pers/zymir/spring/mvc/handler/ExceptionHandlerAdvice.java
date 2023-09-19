package pers.zymir.spring.mvc.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerException(MethodArgumentNotValidException validException) {
        return validException.getMessage();
    }

    @ExceptionHandler(Exception.class)
    // 使用@ResponseStatus注解映射为指定的HTTP状态码
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerException(Exception e) {
        log.info("发生了异常");
        return "error";
    }
}
