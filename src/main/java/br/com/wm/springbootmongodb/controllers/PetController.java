package br.com.wm.springbootmongodb.controllers;

import br.com.wm.springbootmongodb.entities.Pet;
import br.com.wm.springbootmongodb.repositories.PetRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable("id") ObjectId id) {
        return petRepository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pet pet) {
        pet.set_id(id);
        petRepository.save(pet);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pet createPet(@Valid @RequestBody Pet pet) {
        pet.set_id(ObjectId.get());
        petRepository.save(pet);
        return pet;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable ObjectId id) {
        petRepository.delete(petRepository.findBy_id(id));
    }
}
