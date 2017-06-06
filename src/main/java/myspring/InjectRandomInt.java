package myspring;/**
 * Created by Evegeny on 06/06/2017.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface InjectRandomInt {
    int min();
    int max();
}
