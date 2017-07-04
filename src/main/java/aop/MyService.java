package aop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Service
public class MyService {

    @Scheduled(cron = "1/1 * * * * ?")
    @Secured
    public void doWork() {
        System.out.println("WORKING...");
    }
}
