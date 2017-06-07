package quoters;

import lombok.Setter;
import myspring.Benchmark;
import org.springframework.core.env.Environment;

import javax.annotation.PreDestroy;
import javax.swing.*;
import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Benchmark
@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;


    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void killAll(){
        System.out.println("you are terminated...");
    }






}
