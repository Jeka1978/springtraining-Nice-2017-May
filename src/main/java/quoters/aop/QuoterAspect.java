package quoters.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Component
@Aspect
public class QuoterAspect {

    @Pointcut("execution(* quoters..*.say*(..))")
    public void sayMethods(){}

    @Pointcut("@annotation(Deprecated)")
    public void deprecatedMethod(){}

    @Before("sayMethods()")
    public void handleSayMethods(){
        System.out.print("this is quote: ");
    }

}











