package qualifiers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 19/06/2017.
 */
public class Main {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Conf.class);
    }
}
