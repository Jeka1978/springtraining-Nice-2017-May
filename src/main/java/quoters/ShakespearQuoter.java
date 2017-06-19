package quoters;

import lombok.Setter;
import myspring.InjectRandomInt;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Component
@Book
public class ShakespearQuoter implements Quoter {
    @Setter
    @Value("${shake}")
    private String message;

    @InjectRandomInt(min = 4,max = 7)
    private int repeat;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }


}
