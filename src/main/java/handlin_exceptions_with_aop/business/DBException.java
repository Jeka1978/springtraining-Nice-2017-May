package handlin_exceptions_with_aop.business;

/**
 * Created by Evegeny on 04/07/2017.
 */
public class DBException extends RuntimeException {
    public DBException(String message) {
        super(message);
    }
}
