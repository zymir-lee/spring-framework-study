package pers.zymir.spring.bean.cofiguration.v2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = ConfigV2.class)
@RunWith(SpringRunner.class)
public class ConfigTestV2 {

    @Autowired
    private ParentBean parentBean;

    @Test
    public void JavaConfigAssembleTest() {
        Assert.assertNotNull(parentBean);
        Assert.assertNotNull(parentBean.getChildBean());

        parentBean.callChildBean();
    }
}
