package pers.zymir.spring.bean.cofiguration.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigV1 {

    @Bean
    public JavaConfigSampleBean javaConfigSampleBean() {
        return new JavaConfigSampleBean();
    }
}
