package handlin_exceptions_with_aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Service
public class DBServiceImpl implements DBService {
    @Autowired
    private Dao dao;

    @Override
    @Scheduled(cron = "1/5 * * * * ?")
    public void doWork() {

        try {
            dao.savePerson();
        } catch (Exception e) {
            System.out.println("PROBLEM...");
            throw new RuntimeException(e);
        }
    }
}
