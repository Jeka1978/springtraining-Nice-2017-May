package quoters;

import lombok.Setter;
import org.springframework.core.env.Environment;

import javax.swing.*;
import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;


    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

}
