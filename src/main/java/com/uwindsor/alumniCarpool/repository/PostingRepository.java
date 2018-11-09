package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.Posting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostingRepository extends MongoRepository<Posting, String> {
    @Query("{'departureCity': ?0, 'arrivalCity': ?1, 'departureDate': ?2}")
    List<Posting> getPostingsBySearch(String departureCity, String arrivalCity, String departureDate);

}
