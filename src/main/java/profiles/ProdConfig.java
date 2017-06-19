package profiles;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Configuration
@Profile("PROD")
public class ProdConfig {
    @PostConstruct
    public void initProd(){
        System.out.println("PRODUCTION IS WORKING!!!");

    }
}
