package lombok_example;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.Singular;

import java.util.List;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Builder
@Data
public class Person {
    @NonNull
    private String name;
    private int age;
    private int salary;
    @Singular("בירה")
    private List<String> בירות;


    public static void main(String[] args) {
        Person person = Person.builder()
                .name("Ariel")
                .age(37).salary(4).בירה("goldstar").build();

        System.out.println("person = " + person);


    }






}
