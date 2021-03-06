package handlin_exceptions_with_aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Configuration
@ComponentScan
@EnableScheduling
@EnableAspectJAutoProxy
@PropertySource("classpath:mails.properties")
public class DBConf {

}
