package neveruseswitch;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Repository
public class MailDaoImpl implements MailDao {
    private Random random = new Random();
    @Override
    public int mailCode() {
        return random.nextInt(2)+1;
    }
}
