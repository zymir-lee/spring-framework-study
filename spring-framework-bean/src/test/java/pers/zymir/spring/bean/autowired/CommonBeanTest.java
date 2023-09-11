package pers.zymir.spring.bean.autowired;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import pers.zymir.spring.bean.autowired.multiple.MultipleBean;

import java.util.List;

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

    @Autowired
    private List<MultipleBean> multipleBeans;

    @Test
    public void multipleBeanTest() {
        // 如果有多个符合条件的bean可以注入到集合当中（默认按照类型寻找bean）
        // 如果想要注入指定的bean请见qualifier包
        Assert.assertNotNull(multipleBeans);
        for (MultipleBean each : multipleBeans) {
            each.sayHello();
        }
    }
}
