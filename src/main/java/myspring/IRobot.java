package myspring;


import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 06/06/2017.
 */
public class IRobot {
    @InjectByFieldType
    private Speaker speaker;
    @InjectByFieldType
    private Cleaner cleaner;

    @PostConstruct
    public void init(){
        System.out.println(speaker.getClass());
    }

    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
