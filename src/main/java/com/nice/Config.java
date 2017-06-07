package com.nice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.nice")
public class Config {

}
