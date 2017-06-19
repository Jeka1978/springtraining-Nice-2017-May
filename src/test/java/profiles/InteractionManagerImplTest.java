package profiles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 19/06/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StamConf.class)
@ActiveProfiles({"DEV"})
public class InteractionManagerImplTest {
    @Autowired
    private InteractionManager interactionManager;
    @Test
    public void doWork() throws Exception {
        int i = interactionManager.doWork();
        Assert.assertEquals(28,i);
    }

}