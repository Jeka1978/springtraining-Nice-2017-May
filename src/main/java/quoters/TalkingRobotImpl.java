package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */

@Setter
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

    @Autowired
    private Environment environment;

    @Override
    @PostConstruct
    public void talk() {
//        quoters.forEach(quoter -> quoter.sayQuote());

//        quoters.forEach(Quoter::sayQuote);

        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}
