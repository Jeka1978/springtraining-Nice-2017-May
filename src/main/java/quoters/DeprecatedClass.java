package quoters;/**
 * Created by Evegeny on 07/06/2017.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface DeprecatedClass {
    Class value();
}
