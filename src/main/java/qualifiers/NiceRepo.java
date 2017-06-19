package qualifiers;/**
 * Created by Evegeny on 19/06/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Qualifier
@Repository
@Autowired
public @interface NiceRepo {
    DBType value();
}
