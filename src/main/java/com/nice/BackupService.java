package com.nice;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Service
public class BackupService {
    @Scheduled(cron = "1/5 * * * * WED")
    @Scheduled(cron = "1/2 * * * * ?")
    public void doBackup(){
        System.out.println("Backup was created: "+ LocalDateTime.now());
    }

}
