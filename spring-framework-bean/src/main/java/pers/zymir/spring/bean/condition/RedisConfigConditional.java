package pers.zymir.spring.bean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Objects;

public class RedisConfigConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1.获取env对象
        Environment environment = context.getEnvironment();
        // 模拟当redis.enable开启时才加载RedisConfig
        String redisEnableValue = environment.getProperty("redis.enable");
        if (Objects.isNull(redisEnableValue)) {
            return false;
        }
        return Boolean.parseBoolean(redisEnableValue);
    }
}
