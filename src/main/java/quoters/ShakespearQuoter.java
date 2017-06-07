package quoters;

import lombok.Setter;

/**
 * Created by Evegeny on 07/06/2017.
 */
public class ShakespearQuoter implements Quoter {
    @Setter
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }


}
