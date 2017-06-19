package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Component("3")
public class HappyBirthdayMailGenerator implements MailGenerator {
    @Override
    public String generateBody() {
        return "Happy birthday!";
    }
}
