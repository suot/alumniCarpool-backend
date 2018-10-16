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
    public void createOrder(@Valid @RequestBody Order order){
        repository.save(order); //save = update + insert
    }

    /**
     * driver changes the status of an ongoing order: full --> finished;
     * system changes the status of a vacant order automatically: vacant --> full -- when every vacant seats are reserved
     * @param order
     */
    @PostMapping("/modify/{id}")
    public void modifyOrderById(@PathVariable("id") String id, @Valid @RequestBody Order order){
        repository.save(order);
    }

    /**
     * driver changes the status of an ongoing order: full --> finished;
     * system changes the status of a vacant order automatically: vacant --> full -- when every vacant seats are reserved
     * @param id
     */
//    @DeleteMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
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
     * list all vacant orders in db with the constraints of departure, arrival, and departureDate.
     * @param departureCity
     * @param arrivalCity
     * @param departureDate
     * @return
     */
    @GetMapping("/get/allVacant")
    public List<Order> getOrdersBySearch(@RequestParam String departureCity, @RequestParam String arrivalCity, @RequestParam String departureDate){
        return repository.getOrdersBySearch(departureCity, arrivalCity, departureDate);
    }


    /**
     * driver: car.driver.email==email
     * status: status in ["vacant", "full"]
     * @param email: the driver's username
     * @return List<Order>
     */
    @GetMapping("/get/drivers/ongoing/{email}")
    public List<Order> getDriversOngoingOrders(@PathVariable String email){
        return repository.getDriversOngoingOrders(email);
    }

    /**
     * driver: car.driver.email==email
     * status: status = "finished"
     * @param email: the driver's username
     * @return List<Order>
     */
    @GetMapping("/get/drivers/finished/{email}")
    public List<Order> getDriversFinishedOrders(@PathVariable String email){
        return repository.getDriversFinishedOrders(email);
    }

    /**
     * passenger: there exists a seat in car.seats and its passenger.email=email
     * status: status in ['vacant', 'full']
     * @param email: the passenger's username
     * @return
     */
    @GetMapping("/get/passengers/ongoing/{email}")
    public List<Order> getPassengersOngoingOrders(@PathVariable String email){
        return repository.getPassengersOngoingOrders(email);
    }

    /**
     * passenger: there exists a seat in car.seats and its passenger.email=email
     * status: status = "finished"
     * @param email: the passenger's username
     * @return
     */
    @GetMapping("/get/passengers/finished/{email}")
    public List<Order> getPassengersFinishedOrders(@PathVariable String email){
        return repository.getPassengersFinishedOrders(email);
    }
}
