package hibernate_examples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 04/07/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConf.class)
public class HibernateConfTest {

    @Autowired
    PersonService personService;

    @Test
    public void testHibernate() throws Exception {
        Person ariel = new Person("Ariel");
        System.out.println("ariel = " + ariel);
        personService.savePerson(ariel);
        System.out.println("ariel = " + ariel);
        List<Person> all = personService.findAll();
        System.out.println(all);
    }

}