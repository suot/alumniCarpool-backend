package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.Posting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostingRepository extends MongoRepository<Posting, String> {
}
