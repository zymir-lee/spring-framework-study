package pers.zymir.spring.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
// 多个切面通过order指定顺序 越小越先执行
@Order(value = 0)
public class AopAspect {

    @Pointcut("execution(* pers.zymir.spring.aop.advice.*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String name = getJoinPointMethodName(joinPoint);
        log.info("before advice执行, 当前方法：{}", name);
    }

    @After("pointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        String name = getJoinPointMethodName(joinPoint);
        log.info("after advice执行, 当前方法：{}", name);
    }

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String joinPointMethodName = this.getJoinPointMethodName(joinPoint);

        log.info("around advice开始执行, 当前方法: {}", joinPointMethodName);
        Object result = joinPoint.proceed(); // 环绕通知需要手动执行方法，并且可以获取到返回结果
        log.info("around advice执行结束");
        return result;
    }

    @AfterReturning(value = "pointcut()", returning = "returnValue")
    public void afterReturningAdvice(JoinPoint joinPoint, Object returnValue) {
        // returnValue属性获取返回值，可以放到方法参数里拿到
        String joinPointMethodName = getJoinPointMethodName(joinPoint);
        log.info("afterReturningAdvice执行, 当前方法：{} , 返回结果: {}", joinPointMethodName, returnValue);
    }

    @AfterThrowing(value = "pointcut()")
    public void afterThrowingAdvice(JoinPoint joinPoint) {
        String joinPointMethodName = getJoinPointMethodName(joinPoint);
        log.info("afterThrowingAdvice执行, 当前方法：{}", joinPointMethodName);
    }

    private String getJoinPointMethodName(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getName();
    }

}
