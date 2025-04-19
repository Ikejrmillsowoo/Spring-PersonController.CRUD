package controllers;

import models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.PersonRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository repository;
    private List<Person> personList = new ArrayList<>();
   // private AtomicInteger idCounter = new AtomicInteger();
    @GetMapping()
    public Iterable<Person> getPersonList(){
        return repository.findAll();

    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return repository.findOne(id);
    }

    @PutMapping("/add")
    public Person createPerson(@RequestBody Person p){
       repository.save(p);
        return p;
    }
    @PatchMapping("/update")
    public Person updatePerson(@RequestBody Person p){
       return repository.save(p);

    }
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id){
       repository.delete(id);
        return "Person with Id "+ id + " has been removed";
    }
}
