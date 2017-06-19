package profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 19/06/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StamConf.class);
        int i = context.getBean(InteractionManager.class).doWork();
        System.out.println("i = " + i);
    }
}
