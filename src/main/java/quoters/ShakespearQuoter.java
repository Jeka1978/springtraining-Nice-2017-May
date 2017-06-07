package quoters;

import lombok.Setter;
import myspring.InjectRandomInt;

/**
 * Created by Evegeny on 07/06/2017.
 */
public class ShakespearQuoter implements Quoter {
    @Setter
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
