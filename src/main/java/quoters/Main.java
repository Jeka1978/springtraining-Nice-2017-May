package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Evegeny on 07/06/2017.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("conext.xml");
        context.getBeansOfType(Quoter.class).values().forEach(Quoter::sayQuote);

    }
}
