package conditionals;/**
 * Created by Evegeny on 04/07/2017.
 */

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(OnProdCondition.class)
public @interface Prod {
}
