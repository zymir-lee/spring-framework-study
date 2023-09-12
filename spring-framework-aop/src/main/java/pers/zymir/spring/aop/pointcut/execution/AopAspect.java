package pers.zymir.spring.aop.pointcut.execution;

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
public class AopAspect {

    /**
     * execution表达式
     * 下面的表达式表示：*返回类型 包名..(使用..表示当前包及其子包)下任意的类.任意的方法(..)任意的参数列表
     */
    @Pointcut("execution(* pers.zymir.spring.aop.pointcut.execution..*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = AopJoinPointAspect.AopUtil.convert2MethodSignature(joinPoint);
        String name = methodSignature.getMethod().getName();
        log.info("当前方法: {} 被execution代理", name);
    }

}
