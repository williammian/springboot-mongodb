package br.com.wm.springbootmongodb.repositories;

import br.com.wm.springbootmongodb.entities.Pet;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet, String> {

    Pet findBy_id(ObjectId _id);
}
