package screensaver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Configuration
@ComponentScan
public class Conf {
    private Random random = new Random();

    @Bean
    @Scope("prototype")
    public Color color(){
        Color color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
        return color;
    }

    @Bean
    public ColorFrame colorFrame(){
        return new ColorFrame() {
            @Override
            protected Color getColorBean() {
                return color();
            }
        };
    }
}









