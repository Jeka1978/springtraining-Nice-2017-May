package neveruseswitch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Component
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateBody() {
        return "don't call us Nicolas";
    }

    @Override
    public int mailCode() {
        return 2;
    }
}
