package conditionals;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Evegeny on 04/07/2017.
 */
public class OnProdCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        if (System.getenv().get("OS").toLowerCase().contains("windows")) {
            return false;
        }
        return true;
    }
}
