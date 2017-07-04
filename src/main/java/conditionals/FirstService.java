package conditionals;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 04/07/2017.
 */
@Service
@Prod
public class FirstService {
    @PostConstruct
    public void init(){
        System.out.println("First service was created!");
    }


    @Bean(initMethod = "toLowerCase", destroyMethod = "toUpperCase")
    @Lazy
    @Scope("prototype")
    public String str(){
        return "WTF";
    }


}
