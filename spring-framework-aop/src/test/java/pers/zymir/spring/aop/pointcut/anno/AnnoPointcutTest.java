package pers.zymir.spring.aop.pointcut.anno;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = AopAnnoPointcutConfig.class)
@RunWith(SpringRunner.class)
public class AnnoPointcutTest {

    @Autowired
    private AnnoWithinPointcutService annoWithinPointcutService;

    @Test
    public void annoWithInTest() {
        annoWithinPointcutService.foo();
    }
}
