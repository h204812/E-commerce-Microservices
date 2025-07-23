package com.example.SpringMongo.Repository;

import com.example.SpringMongo.models.product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface productRepo extends MongoRepository<product,String> {
}
