package myspring;

/**
 * Created by Evegeny on 06/06/2017.
 */
@Benchmark
public class ConsoleSpeaker implements Speaker {
    public void speak(String message) {
        System.out.println(message);
    }
}
