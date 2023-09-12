package pers.zymir.spring.aop.pointcut.execution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = AopExecutionPointcutConfig.class)
@RunWith(SpringRunner.class)
public class AnnoPointcutTest {

    @Autowired
    private AopExecutionService aopExecutionService;

    @Test
    public void executionPointcutTest() {
        aopExecutionService.foo();
    }
}
