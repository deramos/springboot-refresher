package io.kairos.application.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* io.kairos.application.service.StudentService.getStudent(..)) && args(studentId)")
    public Object validateAndUpdate(ProceedingJoinPoint jb, int studentId) {
        Object returnObject = null;
        if(studentId < 0)
            studentId = -studentId;
        try {
            returnObject = jb.proceed(new Object[]{studentId});
        } catch (Throwable e) {
            LOGGER.error(e.getMessage());
        }
        return returnObject;
    }
}
