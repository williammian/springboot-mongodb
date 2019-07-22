package br.com.wm.springbootmongodb.repositories;

import br.com.wm.springbootmongodb.entities.Person;
import org.bson.types.ObjectId;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    Person findBy_id(ObjectId _id);

    List<Person> findByLastname(@Param("name") String name);
}
