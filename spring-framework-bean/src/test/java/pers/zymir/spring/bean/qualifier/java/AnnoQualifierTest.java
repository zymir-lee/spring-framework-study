package pers.zymir.spring.bean.qualifier.java;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.spring.bean.qualifier.anno.AnnoQualifierBean;
import pers.zymir.spring.bean.qualifier.anno.AnnoQualifierConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AnnoQualifierConfig.class)
public class AnnoQualifierTest {

    // 使用@Qualifier注解注入指定beanId的bean 消除歧义性
    @Autowired
    @Qualifier("one")
    private AnnoQualifierBean beanOne;

    @Autowired
    @Qualifier("two")
    private AnnoQualifierBean beanTwo;

    @Test
    public void qualifierTest() {
        Assert.assertNotNull(beanOne);
        Assert.assertNotNull(beanTwo);
    }
}
