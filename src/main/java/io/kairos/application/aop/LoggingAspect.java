package io.kairos.application.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* io.kairos.application.service.StudentService.*(..))")
    public void logMethodCall(JoinPoint point) {
        System.out.println(point.getSourceLocation() + ": " + point.getSignature().getName());
        LOGGER.info("Service Called");
    }

    @After("execution(* io.kairos.application.service.StudentService.*(..))")
    public void executeMethodCall(JoinPoint point) {
        System.out.println(point.getSourceLocation() + ": " + point.getSignature().getName());
        LOGGER.info("After Service Called");
    }

    @AfterThrowing("execution(* io.kairos.application.service.StudentService.*(..))")
    public void logExceptionThrow(JoinPoint point) {
        System.out.println(point.getSourceLocation() + ": " + point.getSignature().getName());
        LOGGER.info("Throw after Exception Call");
    }
}
