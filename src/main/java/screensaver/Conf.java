package screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Configuration
@ComponentScan
public class Conf {
    private Random random = new Random();

    @Bean
    @Scope(value = "prototype",proxyMode = TARGET_CLASS)
    public Color color(){
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        return color;
    }


}









