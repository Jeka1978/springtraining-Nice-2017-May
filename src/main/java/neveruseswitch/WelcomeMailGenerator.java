package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Component
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateBody() {
        return "Welcome Client!";
    }

    @Override
    public int mailCode() {
        return 1;
    }
}
