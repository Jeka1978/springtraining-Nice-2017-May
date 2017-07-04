package handlin_exceptions_with_aop;

import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Repository
public class DaoImpl implements Dao {
    @Override
    public void savePerson() {
        System.out.println("saving....");
        throw new DBException("fire all dba!!!");
    }
}
