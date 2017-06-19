package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Service
@Profile("PROD")
public class RecorderImpl implements Recorder {

    @Scheduled(cron = "1/1 * * * * ?")
    public void makeStuff(){
        System.out.println("****");
    }
    @Override
    public String getRecord() {
        return "NICE RECORD";
    }
}
