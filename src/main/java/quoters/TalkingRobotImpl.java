package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */

@Setter
@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Autowired
    @Film
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
