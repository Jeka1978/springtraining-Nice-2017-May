package hibernate_examples;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
@EqualsAndHashCode(exclude = "id")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    private String name;


}
