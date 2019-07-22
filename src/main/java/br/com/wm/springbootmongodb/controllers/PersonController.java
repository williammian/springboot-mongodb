package br.com.wm.springbootmongodb.controllers;

import br.com.wm.springbootmongodb.entities.Person;
import br.com.wm.springbootmongodb.repositories.PersonRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable("id") ObjectId id) {
        return personRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPersonById(@PathVariable("id") ObjectId id, @Valid @RequestBody Person person) {
        person.set_id(id);
        personRepository.save(person);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person createPerson(@Valid @RequestBody Person person) {
        person.set_id(ObjectId.get());
        personRepository.save(person);
        return person;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable ObjectId id) {
        personRepository.delete(personRepository.findBy_id(id));
    }
}
