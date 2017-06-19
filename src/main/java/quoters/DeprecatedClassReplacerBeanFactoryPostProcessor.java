package quoters;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by Evegeny on 19/06/2017.
 */
public class DeprecatedClassReplacerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (annotation != null) {
                Class newClass = annotation.value();
                beanDefinition.setBeanClassName(newClass.getName());
            }
        }
    }
}





