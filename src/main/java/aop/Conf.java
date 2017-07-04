package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Configuration
@ComponentScan(basePackages = "aop")
@EnableScheduling
@EnableAspectJAutoProxy
public class Conf {
}
