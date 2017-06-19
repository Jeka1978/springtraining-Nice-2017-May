package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Service
public class MailSenderImpl implements MailSender {
    @Autowired
    private Map<String, MailGenerator> map;

    @Autowired
    private MailDao mailDao;

    @Override
    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        String mailCode = String.valueOf(mailDao.mailCode());
        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new UnsupportedOperationException(mailCode + " not supported yet");
        }
        String body = mailGenerator.generateBody();
        send(body);
    }

    private void send(String body) {
        System.out.println("sending html... "+body);
    }
}








