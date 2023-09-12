package pers.zymir.spring.aop.advice.joinpoint;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class AopJoinPointAspect {

    @Pointcut("execution(* pers.zymir.spring.aop.advice.*.*(..))")
    public void pointcut() {

    }

    // @AfterReturning @AfterThrowing @After处理JoinPoint方式一致
    @Before("pointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {


    }

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = AopUtil.convert2MethodSignature(joinPoint);
        // 1.获取代理的method
        Method method = methodSignature.getMethod();
        // 2.获取代理的类
        Class<?> declaringType = methodSignature.getDeclaringType();
        log.info("类名：{}", declaringType.getName());
        // 3.获取返回值类型
        Class<?> returnType = methodSignature.getReturnType();
        log.info("返回值类名：{}", returnType.getName());
        // 4.获取当前被代理方法的参数
        Object[] args = joinPoint.getArgs();
        log.info("参数列表：{}", Arrays.toString(args));
        // ...等等

        log.info("around advice开始执行, 当前方法: {}", method.getName());
        Object result = joinPoint.proceed(); // 环绕通知需要手动执行方法，并且可以获取到返回结果
        log.info("around advice执行结束");
        return result;
    }


    public static class AopUtil {

        public static MethodSignature convert2MethodSignature(JoinPoint joinPoint) {
            return (MethodSignature) joinPoint.getSignature();
        }
    }
}
