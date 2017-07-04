package nested_transaction_problems;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Component
@Aspect
public class TransactionHandlerAspect {
    @Around("@annotation(Transaction)")
    public void doWithTransaction(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("***********Transaction Opened ***************");
        pjp.proceed();
        System.out.println("***********Transaction closed ***************");
    }
}
