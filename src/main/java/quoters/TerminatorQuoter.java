package quoters;

import lombok.Setter;
import myspring.Benchmark;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Benchmark
@Component
@Film
public class TerminatorQuoter implements Quoter {


    private List<String> messages;


    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    @PreDestroy
    public void killAll(){
        System.out.println("you are terminated...");
    }






}
