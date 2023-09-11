package pers.zymir.spring.bean.autowired;

import org.springframework.stereotype.Component;

@Component
public class CommonBean {

    public void sayHello() {
        System.out.println("Hello, Spring");
    }
}
