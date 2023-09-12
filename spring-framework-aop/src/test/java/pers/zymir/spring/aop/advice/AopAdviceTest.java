package pers.zymir.spring.aop.advice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = AopAdviceConfig.class)
@RunWith(SpringRunner.class)
public class AopAdviceTest {

    @Autowired
    private Service service;

    @Test
    public void aopAdviceTest() {
        System.out.println(service.queryUserName(123L));
    }

    @Test
    public void aopThrowingTest() {
        Assert.assertThrows(RuntimeException.class, () -> service.queryUserNameThrowing(123L));
    }
}
