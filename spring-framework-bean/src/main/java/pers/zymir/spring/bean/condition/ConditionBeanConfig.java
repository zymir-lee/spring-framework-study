package pers.zymir.spring.bean.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:redis.properties")
public class ConditionBeanConfig {

    public static class RedisConfig {
        private String host;
        private String port;
        private String password;

        @Override
        public String toString() {
            return host + ":" + port;
        }
    }

    @Bean
    @Conditional(RedisConfigConditional.class)
    public RedisConfig redisConfig() {
        RedisConfig redisConfig = new RedisConfig();
        redisConfig.host = "127.0.0.1";
        redisConfig.port = "3306";
        redisConfig.password = "123456";
        return redisConfig;
    }

}
