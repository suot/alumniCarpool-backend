package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
    //4 statuses: Vacant -> Full -> On-board -> Finished
    @Query("{'departureCity': ?0, 'arrivalCity': ?1, 'departureDate': ?2, 'status': {'$in': ['Vacant', 'Full']}}")
    List<Order> getOrdersBySearch(String departureCity, String arrivalCity, String departureDate);

    @Query("{'car.driver.email': ?0, 'status': {'$in': ['Vacant', 'Full']}}")
    List<Order> getDriversOngoingOrders(String email);

    @Query("{'car.driver.email': ?0, 'status': 'Finished'}")
    List<Order> getDriversFinishedOrders(String email);

    @Query("{'status': {'$in': ['Vacant', 'Full']}, 'car.seats': {$elemMatch:{'passenger.email': ?0}}}")
    List<Order> getPassengersOngoingOrders(String email);

    @Query("{'status': 'Finished', 'car.seats': {$elemMatch:{'passenger.email': ?0}}}")
    List<Order> getPassengersFinishedOrders(String email);

}
