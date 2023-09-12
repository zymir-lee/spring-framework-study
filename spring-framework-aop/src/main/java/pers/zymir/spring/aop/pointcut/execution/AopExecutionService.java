package pers.zymir.spring.aop.pointcut.execution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AopExecutionService {
    public void foo() {
        log.info("AopExecutionService方法执行");
    }
}
