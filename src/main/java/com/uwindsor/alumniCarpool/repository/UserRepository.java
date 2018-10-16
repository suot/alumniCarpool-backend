package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
