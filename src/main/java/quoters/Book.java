package quoters;/**
 * Created by Evegeny on 19/06/2017.
 */

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Qualifier("book")
public @interface Book {
}
