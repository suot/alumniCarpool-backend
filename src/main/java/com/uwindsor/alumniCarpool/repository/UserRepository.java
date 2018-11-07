package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{'email': ?0}")
    Optional<List<User>> getUserByEmail(String email);

}
