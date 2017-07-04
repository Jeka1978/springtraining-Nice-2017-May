package handlin_exceptions_with_aop.business;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Component
@Aspect
public class ExceptionHandlerAspect {

    private Map<DBException, Void> map = new WeakHashMap<>();

    @Value("${dbaMails}")
    private String[] mails;

    @Pointcut("execution(* handlin_exceptions_with_aop.business..*(..))")
    public void allBusinessMethods(){}

    @AfterThrowing(pointcut = "allBusinessMethods()", throwing = "ex")
    public void handleDbExceptions(DBException ex) {
        if (!map.containsKey(ex)) {
            for (String mail : mails) {
                System.out.println("sending to = " + mail);
                System.out.println(ex.getMessage());
            }
            map.put(ex, null);
        }
    }















}
