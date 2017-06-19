package screensaver;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 19/06/2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        while (true) {
            context.getBean(ColorFrame.class).
                    moveToRandomLocation();
            Thread.sleep(50);
        }
    }
}
