package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Service
public class MailSenderImpl implements MailSender {
    private Map<Integer, MailGenerator>  map = new HashMap<>();


    @Autowired
    private void initMap(List<MailGenerator> mailGenerators) {
        for (MailGenerator mailGenerator : mailGenerators) {
            int mailCode = mailGenerator.mailCode();
            if (map.containsKey(mailCode)) {
                throw new RuntimeException("mailcode " + mailCode + " already in use");
            }
            map.put(mailCode, mailGenerator);
        }
    }

    @Autowired
    private MailDao mailDao;

    @Override
    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        int mailCode = mailDao.mailCode();
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








