package br.com.wm.springbootmongodb.repositories;

import br.com.wm.springbootmongodb.entities.Person;
import br.com.wm.springbootmongodb.entities.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    Product findBy_id(ObjectId _id);

    List<Product> findByCode(@Param("code") String code);

}
