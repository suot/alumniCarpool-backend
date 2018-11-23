package com.uwindsor.alumniCarpool.repository;

import com.uwindsor.alumniCarpool.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{
    //4 status: Boarding -> On-board -> Finished
    @Query("{'departureCity': ?0, 'arrivalCity': ?1, 'departureDate': ?2, 'status': {'$in': ['Boarding', 'On-board']}}")
    List<Order> getOrdersBySearch(String departureCity, String arrivalCity, String departureDate);

    @Query("{'driver.id': ?0, 'status': {'$in': ['Boarding', 'On-board']}}")
    List<Order> getDriversOngoingOrders(String id);

    @Query("{'driver.id': ?0, 'status': 'Finished'}")
    List<Order> getDriversFinishedOrders(String id);

    @Query("{'status': {'$in': ['Boarding', 'On-board']}, 'driver.car.seats': {$elemMatch:{'passenger.id': ?0}}}")
    List<Order> getPassengersOngoingOrders(String id);

    @Query("{'status': 'Finished', 'driver.car.seats': {$elemMatch:{'passenger.id': ?0}}}")
    List<Order> getPassengersFinishedOrders(String id);

}
