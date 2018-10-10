package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Seat;
import com.uwindsor.alumniCarpool.repository.SeatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private SeatRepository seatRepository;

    public SeatController(SeatRepository seatRepository){
        this.seatRepository = seatRepository;
    }

    @GetMapping("/all")
    public List<Seat> getAll(){
        List<Seat> seats = this.seatRepository.findAll();
        return seats;
    }

    @PutMapping
    public void insert(@RequestBody Seat seat){

    }

}
