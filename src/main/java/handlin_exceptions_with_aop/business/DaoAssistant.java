package handlin_exceptions_with_aop.business;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Component
public class DaoAssistant {
    public void save() {
        throw new DBException("fire all dba!!!");
    }
}
