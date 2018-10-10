package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
}
