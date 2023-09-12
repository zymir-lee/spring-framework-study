package pers.zymir.spring.aop.pointcut.anno;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Aop(desc = "测试@within")
public class AnnoWithinPointcutService {
    public void foo() {
        log.info("AnnoPointCutService execute");
    }
}
