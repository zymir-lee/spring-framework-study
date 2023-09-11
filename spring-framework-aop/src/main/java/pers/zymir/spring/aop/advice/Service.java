package pers.zymir.spring.aop.advice;

import org.springframework.stereotype.Component;

@Component
public class Service {
    public String queryUserName(long userId) {
        return userId + ": amormz";
    }

    public String queryUserNameThrowing(long userId) {
        if (userId == 123L) {
            throw new RuntimeException("throwing");
        }
        return userId + ": zymir";
    }
}