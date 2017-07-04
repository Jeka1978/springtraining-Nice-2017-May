package hibernate_examples;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(timeout = 1000)
    public void savePerson(Person person) {
        entityManager.persist(person);
        person.setName(person.getName().toUpperCase());
    }

    @Override
    @Transactional
    public List<Person> findAll() {
//        Query query = entityManager.createQuery("from Person");
        Query query = entityManager.createNamedQuery("allPersons");
        List<Person> persons = query.getResultList();

        return persons;
    }
}





