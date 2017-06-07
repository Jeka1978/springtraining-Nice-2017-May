package quoters;

/**
 * Created by Evegeny on 07/06/2017.
 */
public class ShakespearQuoter implements Quoter {
    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
