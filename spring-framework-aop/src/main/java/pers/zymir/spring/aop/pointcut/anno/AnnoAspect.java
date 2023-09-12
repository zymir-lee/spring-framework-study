package pers.zymir.spring.aop.pointcut.anno;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pers.zymir.spring.aop.advice.joinpoint.AopJoinPointAspect;

@Component
@Aspect
@Slf4j
public class AnnoAspect {

    /**
     * @within pointcut指示器
     * 类上有某个注解时，该类下方法执行会被拦截
     * 如果注解是可继承的，那么子类执行方法也会被拦截
     */
    @Pointcut("@within(pers.zymir.spring.aop.pointcut.anno.Aop)")
    public void annoWithIn() {
    }

    @Before("annoWithIn()")
    public void annoWithInBeforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = AopJoinPointAspect.AopUtil.convert2MethodSignature(joinPoint);
        String name = methodSignature.getMethod().getName();
        log.info("当前方法：{} 被拦截", name);
    }
}
