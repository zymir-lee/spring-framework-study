package pers.zymir.spring.bean.value;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// 绑定properties配置文件
@PropertySource("classpath:value.properties")
public class SpringValueConfig {
}
