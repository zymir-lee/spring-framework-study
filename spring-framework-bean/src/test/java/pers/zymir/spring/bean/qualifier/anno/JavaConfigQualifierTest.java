package pers.zymir.spring.bean.qualifier.anno;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.spring.bean.qualifier.java.JavaQualifierConfig;
import pers.zymir.spring.bean.qualifier.java.QualifierBean;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JavaQualifierConfig.class)
public class JavaConfigQualifierTest {

    // 使用@Qualifier注解注入指定beanId的bean 消除歧义性
    @Autowired
    @Qualifier("one")
    private QualifierBean beanOne;

    @Autowired
    @Qualifier("two")
    private QualifierBean beanTwo;

    @Test
    public void qualifierTest() {
        Assert.assertNotNull(beanOne);
        Assert.assertNotNull(beanTwo);
    }
}
