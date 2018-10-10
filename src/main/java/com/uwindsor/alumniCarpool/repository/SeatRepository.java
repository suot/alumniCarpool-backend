package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.Seat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends MongoRepository<Seat, String> {

}
