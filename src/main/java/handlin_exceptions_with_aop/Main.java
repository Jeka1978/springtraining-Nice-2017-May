package handlin_exceptions_with_aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 04/07/2017.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DBConf.class);
    }
}
