package pers.zymir.spring.bean.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class AssembleBean {

    @Autowired
    private CommonBean commonBean;

    public void callCommonBean() {
        commonBean.sayHello();
    }
}
