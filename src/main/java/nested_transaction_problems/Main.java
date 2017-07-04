package nested_transaction_problems;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 04/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        MyService myService = context.getBean(MyService.class);

        myService.doX();

        System.out.println("****************");

        myService.doY();





    }
}
