package com.harry.springbootrest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type,Class-name.Method-name(args)
    @Before("execution(* com.harry.springbootrest.service.JobService.*(..))")
    public void callMethod() {
        LOGGER.info("Method called");
    }



    @After("execution(* com.harry.springbootrest.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp)
    {
        LOGGER.info("Method called :"+ jp.getSignature().getName());
    }


    @AfterThrowing("execution(* com.harry.springbootrest.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp)
    {
        LOGGER.info("Method has some issue :"+ jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.harry.springbootrest.service.JobService.getJob(..))")
    public void logMethodSucessfully(JoinPoint jp)
    {
        LOGGER.info("Method called sucessfully :"+ jp.getSignature().getName());
    }
}
