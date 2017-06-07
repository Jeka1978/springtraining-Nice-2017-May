package quoters;

import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */

@Setter
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoters;

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
