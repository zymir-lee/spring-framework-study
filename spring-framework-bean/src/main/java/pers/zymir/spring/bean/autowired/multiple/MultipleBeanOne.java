package pers.zymir.spring.bean.autowired.multiple;

import org.springframework.stereotype.Component;

@Component
public class MultipleBeanOne implements MultipleBean {
    @Override
    public void sayHello() {
        System.out.println(this.getClass().getName());
    }
}
