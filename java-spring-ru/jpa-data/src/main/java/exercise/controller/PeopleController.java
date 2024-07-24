package exercise.controller;

import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

import exercise.model.Person;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person show(@PathVariable long id) {
        return personRepository.findById(id).get();
    }

    // BEGIN
    @GetMapping
    public ResponseEntity<List<Person>> showAll() {
        return ResponseEntity.ok().body(personRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        personRepository.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Person> findPers = personRepository.findById(id);
        findPers.ifPresent(person -> personRepository.delete(person));
    }
    // END
}
