package quoters;

import org.springframework.beans.factory.FactoryBean;

import java.util.Random;

/**
 * Created by Evegeny on 19/06/2017.
 */
public class IntegerFactory  {

    public int randomInt(){
        Random random = new Random();
        return random.nextInt(100);
    }


}
