package screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Evegeny on 19/06/2017.
 */
@Component
public class ColorFrame extends JFrame {
    private Random random = new Random();
    @Autowired
    private Color color;

    @PostConstruct
    public void init(){
        System.out.println(color.getClass());
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        System.out.println(color);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(100,100);
        getContentPane().setBackground(color);
        setVisible(true);
    }

    public void moveToRandomLocation() {
        setLocation(random.nextInt(800),random.nextInt(600));

        getContentPane().setBackground(color);
        repaint();
    }

}











