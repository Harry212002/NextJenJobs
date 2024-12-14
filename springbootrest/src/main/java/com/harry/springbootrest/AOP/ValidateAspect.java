package com.harry.springbootrest.AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidateAspect {

    private static final Logger LOGGER= LoggerFactory.getLogger(ValidateAspect.class);
    @Around("execution(* com.harry.springbootrest.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {
        if(postId<0)
        {
            LOGGER.info("Postid is validated and updated");
            postId=-postId;
            LOGGER.info("new Postid :"+postId);
        }
        Object object=jp.proceed(new Object[]{postId});

        return object;
    }
}
