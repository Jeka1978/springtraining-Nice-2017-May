package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateBody() {
        return "Welcome Client!";
    }
}
