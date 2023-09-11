package pers.zymir.spring.bean.autowired;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = AutowiredConfig.class)
@RunWith(SpringRunner.class)
public class CommonBeanTest {

    @Autowired
    private CommonBean commonBean;

    @Test
    public void commonBeanTest() {
        Assert.assertNotNull(commonBean);
        commonBean.sayHello();
    }

    @Autowired
    private AssembleBean assembleBean;

    @Test
    public void assembleTest() {
        assembleBean.callCommonBean();
    }
}
