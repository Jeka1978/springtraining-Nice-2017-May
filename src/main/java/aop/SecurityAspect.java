package aop;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Component
@Aspect
public class SecurityAspect {
    @Pointcut("@annotation(Secured)")
    public void securedMethod(){}


    @Around("securedMethod()")
    @SneakyThrows
    public Object handleSecurityMethod(ProceedingJoinPoint pjp) {
        if (System.getenv().get("OS").toLowerCase().contains("windows")) {
            throw new SecurityException("not allowed to run this on windows!");
        }
        else {
            return pjp.proceed();
        }













    }








}
