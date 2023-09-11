package pers.zymir.spring.bean.autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 指定当前类为配置类
@ComponentScan // 默认扫描当前包及其子包下的类
public class AutowiredConfig {

}
