package neveruseswitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Service
public class MailSenderImpl implements MailSender {

    @Autowired
    private MailDao mailDao;
    @Override
    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail() {
        int mailCode = mailDao.mailCode();
        if (mailCode == 1) {
            //50 lines of code
            System.out.println("Welcome mail was sent");
        }
        else {
            //70 lines of code
            System.out.println("Don't call us we call you");
        }

    }
}





