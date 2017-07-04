package hibernate_examples;

import java.util.List;

/**
 * Created by Evegeny on 04/07/2017.
 */
public interface PersonService {
    void savePerson(Person person);
    List<Person> findAll();
}
