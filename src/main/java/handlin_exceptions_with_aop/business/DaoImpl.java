package handlin_exceptions_with_aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Repository
public class DaoImpl implements Dao {
    @Autowired
    private DaoAssistant assistant;
    @Override
    public void savePerson() {
        System.out.println("saving....");
        assistant.save();
    }
}
