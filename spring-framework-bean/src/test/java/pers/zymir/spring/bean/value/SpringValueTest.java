package pers.zymir.spring.bean.value;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = SpringValueConfig.class)
@RunWith(SpringRunner.class)
public class SpringValueTest {

    /**
     * 使用value+spel表达式注入配置文件的值
     */
    @Value("${properties.test}")
    private String proValue;

    @Test
    public void valueTest() {
        Assert.assertNotNull(proValue);
        System.out.println(proValue);
    }
}
