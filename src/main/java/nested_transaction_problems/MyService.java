package nested_transaction_problems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Service
public class MyService {
    @SelfInject
    private MyService myProxy;

    public void doX(){
        System.out.println("XXXXXXXXXXXXX");
        myProxy.doY();
    }

    @Transaction
    public void doY(){
        System.out.println("YYYYYYYYYYYYY");
    }
}
