package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 7)
    private int repeat;

    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVvvvvvvvvvvvv");
        }
    }
}
