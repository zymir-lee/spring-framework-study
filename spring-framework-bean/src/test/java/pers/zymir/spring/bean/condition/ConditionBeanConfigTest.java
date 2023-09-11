package pers.zymir.spring.bean.condition;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = ConditionBeanConfig.class)
@RunWith(SpringRunner.class)
public class ConditionBeanConfigTest {

    @Autowired(required = false)
    private ConditionBeanConfig.RedisConfig redisConfig;
    @Autowired
    private Environment environment;

    @Test
    public void conditionalBeanTest() {
        String redisEnableValue = environment.getProperty("redis.enable");
        if (Boolean.parseBoolean(redisEnableValue)) {
            Assert.assertNotNull(redisConfig);
            System.out.println(redisConfig.toString());
        } else {
            Assert.assertNull(redisConfig);
        }
    }
}
