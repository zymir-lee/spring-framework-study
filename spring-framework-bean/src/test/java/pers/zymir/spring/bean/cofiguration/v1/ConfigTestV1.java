package pers.zymir.spring.bean.cofiguration.v1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = ConfigV1.class)
@RunWith(SpringRunner.class)
public class ConfigTestV1 {

    @Autowired
    private JavaConfigSampleBean javaConfigSampleBean;

    @Test
    public void javaConfigBeanTest() {
        // 通过Java代码+@Bean注解注册的Bean
        Assert.assertNotNull(javaConfigSampleBean);
        javaConfigSampleBean.sayHello();
    }
}
