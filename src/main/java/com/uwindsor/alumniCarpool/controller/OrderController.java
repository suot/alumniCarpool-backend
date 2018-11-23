package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Order;
import com.uwindsor.alumniCarpool.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {
    /*
        GET 	/device-management/devices : Get all devices
        POST 	/device-management/devices : Create a new device

        GET 	/device-management/devices/{id} : Get the device information identified by "id"
        PUT 	/device-management/devices/{id} : Update the device information identified by "id"
        DELETE	/device-management/devices/{id} : Delete device by "id"
    */

    @Autowired
    private OrderRepository repository;

    /**
     * driver creates a new order in db
     * @param order
     */
    //@PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create")
    public void saveOrder(@RequestBody Order order){
        repository.save(order); //save = update + insert
    }

    /**
     * driver changes the status of an ongoing order: Boarding --> On-board;
     * @param order
     */
    @PutMapping("/update/{id}")
    public void updateOrderById(@RequestBody Order order){
        repository.save(order);
    }

    /**
     * driver deletes the order
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    /**
     * It is revoked for changing one order's status
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Optional<Order> getOrderById(@PathVariable String id){
        return repository.findById(id);
    }


    /**
     * list all Boarding and On-board orders in db with the constraints of departure, arrival, and departureDate.
     * @param departureCity
     * @param arrivalCity
     * @param departureDate
     * @return
     */
    @GetMapping("/get/allOngoing")
    public List<Order> getOrdersBySearch(@RequestParam String departureCity, @RequestParam String arrivalCity, @RequestParam String departureDate){
        return repository.getOrdersBySearch(departureCity, arrivalCity, departureDate);
    }


    /**
     * driver: car.driver.email==email
     * status: status in ["Boarding", "On-board"]
     * @param id: the driver's id
     * @return List<Order>
     */
    @GetMapping("/get/drivers/ongoing")
    public List<Order> getDriversOngoingOrders(@RequestParam String id){
        return repository.getDriversOngoingOrders(id);
    }

    /**
     * driver: car.driver.email==email
     * status: status = "finished"
     * @param id: the driver's id
     * @return List<Order>
     */
    @GetMapping("/get/drivers/finished")
    public List<Order> getDriversFinishedOrders(@RequestParam String id){
        return repository.getDriversFinishedOrders(id);
    }

    /**
     * passenger: there exists a seat in car.seats and its passenger.email=email
     * status: status in ['Boarding', 'On-board']
     * @param id: the passenger's id
     * @return
     */
    @GetMapping("/get/passengers/ongoing")
    public List<Order> getPassengersOngoingOrders(@RequestParam String id){
        return repository.getPassengersOngoingOrders(id);
    }

    /**
     * passenger: there exists a seat in car.seats and its passenger.email=email
     * status: status = "finished"
     * @param id: the passenger's id
     * @return
     */
    @GetMapping("/get/passengers/finished")
    public List<Order> getPassengersFinishedOrders(@RequestParam String id){
        return repository.getPassengersFinishedOrders(id);
    }
}
