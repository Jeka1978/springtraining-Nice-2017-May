package qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static qualifiers.DBType.MONGO;
import static qualifiers.DBType.ORACLE;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Service
public class NiceService {
    @NiceRepo(MONGO)
    private Dao dao;

    @NiceRepo(ORACLE)
    private Dao backupDao;

    @Scheduled(cron = "1/1 * * * * ?")
    public void doWork(){
        System.out.println("Working...");
        dao.save();
    }

    @Scheduled(cron = "1/2 * * * * ?")
    public void doBackup(){
        System.out.println("Backuping...");
        backupDao.save();
    }






}
