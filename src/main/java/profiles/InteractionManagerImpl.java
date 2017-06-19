package profiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Service
public class InteractionManagerImpl implements InteractionManager {
    @Autowired
    private Recorder recorder;

    @Override
    public int doWork() {
        String record = recorder.getRecord();
        return record.length();
    }
}
