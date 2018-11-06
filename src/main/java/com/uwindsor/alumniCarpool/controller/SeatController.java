package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Seat;
import com.uwindsor.alumniCarpool.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatRepository repository;

    /**
     * create a new seat
     * @param seat
     */
    @PostMapping("/create")
    public void createSeat(@Valid @RequestBody Seat seat){
        repository.save(seat); //save = update + insert
    }

    /**
     * modify a seat when passenger selects it or cancels his/her reservation
     * @param id
     * @param seat
     */
    @PostMapping("/update/{id}")
    public void updateSeatById(@PathVariable("id") String id, @Valid @RequestBody Seat seat){
        repository.save(seat);
    }

    /**
     * delete a seat when driver cancels the order
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteSeat(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    /**
     * get seat by id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Optional<Seat> getSeatById(@PathVariable String id){
        return repository.findById(id);
    }

}
