package pers.zymir.spring.bean.cofiguration.v0;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.spring.bean.cofiguration.v0.beans.BeanV0;
import pers.zymir.spring.bean.cofiguration.v0.config.JavaConfigGuide;

@ContextConfiguration(classes = JavaConfigGuide.class)
@RunWith(SpringRunner.class)
public class ConfigTest {

    @Autowired
    private BeanV0 beanV0;

    @Test
    public void configTest() {
        // 配置了基础包是BasePackage.class所在的类 可以正常注入
        Assert.assertNotNull(beanV0);
    }
}
