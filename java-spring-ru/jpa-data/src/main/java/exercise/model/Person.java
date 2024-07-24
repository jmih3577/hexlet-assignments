package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.Data;


// BEGIN
@Entity
@Table(name="person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    public Long Id;

    public String firstName;
    public String lastName;
}
// END
