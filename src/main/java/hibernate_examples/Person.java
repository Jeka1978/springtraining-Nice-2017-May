package hibernate_examples;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Evegeny on 04/07/2017.
 */


@NamedQueries(
        @NamedQuery(name = "allPersons",query = "from Person")
)

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    public Person(String name) {
        this.name = name;
    }
}
