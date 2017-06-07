package myspring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;

/**
 * Created by Evegeny on 06/06/2017.
 */
@ComponentScan(lazyInit = true, basePackages = "com.nice")
public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InterruptedException {
      /*  IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();*/
        NiceService niceService = ObjectFactory.getInstance().createObject(NiceService.class);
        while (true) {
            niceService.doWork();
            niceService.drinkBeer();
            Thread.sleep(2000);
        }
    }
}
