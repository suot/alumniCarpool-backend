package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Car;
import com.uwindsor.alumniCarpool.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository repository;

    /**
     * create a new car
     * @param car
     */
    @PostMapping("/create")
    public void createCar(@Valid @RequestBody Car car){
        repository.save(car);
    }

    /**
     * modify a car
     * @param id
     */
    @PostMapping("/update/{id}")
    public void updateCarById(@PathVariable("id") String id, @Valid @RequestBody Car car){
        repository.save(car);
    }

    /**
     * delete a car when driver cancels the order
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    /**
     * get car by id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Optional<Car> getCarById(@PathVariable String id){
        return repository.findById(id);
    }
}
