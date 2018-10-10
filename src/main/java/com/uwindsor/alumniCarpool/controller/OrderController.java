package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Order;
import com.uwindsor.alumniCarpool.model.Seat;
import com.uwindsor.alumniCarpool.repository.CarRepository;
import com.uwindsor.alumniCarpool.repository.SeatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PutMapping
    public void insert(@RequestBody Seat seat){

    }

    @RequestMapping
    public Order getOrderById(@RequestBody String id){

        return null;
    }
    
}
