package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Car;
import com.uwindsor.alumniCarpool.model.User;
import com.uwindsor.alumniCarpool.repository.CarRepository;
import com.uwindsor.alumniCarpool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    /**
     * create a new user
     * @param user
     */
    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        repository.save(user);
    }

    /**
     * modify a user
     * @param id
     */
    @PostMapping("/update/{id}")
    public void updateUserById(@PathVariable("id") String id, @RequestBody User user){
        repository.save(user);
    }

    /**
     * delete a user by admin
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    /**
     * get User by id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Optional<User> getUserById(@PathVariable String id){
        return repository.findById(id);
    }
}
