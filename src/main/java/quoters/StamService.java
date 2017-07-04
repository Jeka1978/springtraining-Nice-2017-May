package quoters;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Service
public class StamService {
    @PostConstruct
    public void sayThing() {
        System.out.println("Bla bla bla");
    }
}
