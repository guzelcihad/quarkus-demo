package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.HttpMethod;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cihad G&uuml;zel
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {
        return repository.findById(id)
                .map(p -> ResponseEntity.ok(p))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody Person person) {
        repository.save(person);
    }

//    @PutMapping("{id}")
////    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") int id,
////                                               @RequestBody Person person) {
////        return repository.findById(id)
////
////    }

    @GetMapping
    @RequestMapping("filter")
    public List<Person> filterByAge() {
        return repository.findAll().stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toList());
    }
}
