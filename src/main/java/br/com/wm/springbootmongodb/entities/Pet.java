package br.com.wm.springbootmongodb.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Pet {

    @Id
    public ObjectId _id;
    public String name;
    public String species;
    public String breed;

    public Pet() {}

    public Pet(ObjectId _id, String name, String species, String breed) {
        this._id = _id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(_id, pet._id) &&
                Objects.equals(name, pet.name) &&
                Objects.equals(species, pet.species) &&
                Objects.equals(breed, pet.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, name, species, breed);
    }
}
