package com.niit.userpizzaervice.repository;


import com.niit.userpizzaervice.domain.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserPizzaRepository extends MongoRepository<Pizza,Integer> {

}
