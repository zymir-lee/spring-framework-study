package pers.zymir.spring.bean.autowired.required;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.zymir.spring.bean.autowired.AssembleBean;

@Component
public class RequiredBean {

    // 设置required为false 表示这个bean是非必需的
    @Autowired(required = false)
    private AssembleBean assembleBean;

}
