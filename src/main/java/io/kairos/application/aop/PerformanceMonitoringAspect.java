package io.kairos.application.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    @Around("execution(* io.kairos.application.service.StudentService.*(..))")
    public void monitorTime() {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken: {}", end - start);
    }
}
