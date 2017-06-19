package quoters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Configuration
@PropertySource("classpath:qoutes.properties")
@ComponentScan(basePackages = {"quoters","myspring"})
public class MyConfig {
  /*  @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        return new PropertySourcesPlaceholderConfigurer();
    } not needed since 4.3/*/
}
