package pers.zymir.spring.bean.qualifier.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaQualifierConfig {

    @Bean
    // 使用qualifier指定beanId
    @Qualifier("one")
    public QualifierBean beanOne() {
        return new BeanOne();
    }

    // 使用@Bean注解的属性也可以
    @Bean("two")
    public QualifierBean beanTwo() {
        return new BeanTwo();
    }
}
