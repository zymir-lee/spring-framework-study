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
        log.info("@within advice 当前方法：{} 被拦截", name);
    }

    @Pointcut("@annotation(pers.zymir.spring.aop.pointcut.anno.AnnoAop)")
    public void anno() {
    }

    /**
     * @annotation pointcut指示器
     * 拦截具有指定注解的方法, 如果希望类上具有该注解也被拦截可以使用布尔表达式：
     * @annotation(pers.zymir.spring.aop.pointcut.anno.AnnoAop) || @within(pers.zymir.spring.aop.pointcut.anno.AnnoAop)
     */
    @Before("anno()")
    public void annoInBeforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = AopJoinPointAspect.AopUtil.convert2MethodSignature(joinPoint);
        String name = methodSignature.getMethod().getName();
        log.info("@annotation advice 当前方法：{} 被拦截", name);
    }
}
