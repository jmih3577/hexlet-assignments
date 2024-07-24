package exercise.controller;

import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping(path = "/people")
    public List<Person> showAll() {
        return personRepository.findAll();
    }
    @PostMapping(path = "/people")
    public Person create(@RequestBody Person person) {
        personRepository.save(person);
        return person;
    }
    @DeleteMapping(path = "/people/{id}")
    public void delete(@PathVariable Long id) {
        Optional<Person> findPers = personRepository.findById(id);
        findPers.ifPresent(person -> personRepository.delete(person));
    }
    // END
}
