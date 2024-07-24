package exercise.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


// BEGIN
@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long id;

    public String firstName;
    public String lastName;
}
// END
