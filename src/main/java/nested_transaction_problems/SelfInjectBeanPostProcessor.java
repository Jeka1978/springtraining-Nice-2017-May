package nested_transaction_problems;

import lombok.SneakyThrows;
import nested_transaction_problems.SelfInject;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class SelfInjectBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SelfInject.class)) {
                map.put(beanName, bean);
            }
        }
        return bean;
    }

    @Override
    @SneakyThrows
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            Object originalBean = map.get(beanName);
            Field[] fields = originalBean.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(SelfInject.class)) {
                    field.setAccessible(true);
                    field.set(originalBean,bean);
                }
            }
        }
        return bean;
    }
}
