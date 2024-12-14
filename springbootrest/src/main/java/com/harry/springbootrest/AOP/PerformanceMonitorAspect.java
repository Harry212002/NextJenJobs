package com.harry.springbootrest.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

    private static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.harry.springbootrest.service.JobService.*(..))")
    public Object MonitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();
        Object object=jp.proceed();
        long end=System.currentTimeMillis();
        LOGGER.info("Time taken :"+jp.getSignature().getName()+" "+(end-start)+" ms");
        return object;
    }
}
