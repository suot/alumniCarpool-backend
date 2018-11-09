package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.Posting;
import com.uwindsor.alumniCarpool.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/postings")
public class PostingController {
    @Autowired
    private PostingRepository repository;

    /**
     * create a new posting
     * @param posting
     */
    @PostMapping("/create")
    public void createPosting(@Valid @RequestBody Posting posting){
        repository.save(posting);
    }


    /**
     * delete a posting
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deletePosting(@PathVariable("id") String id){
        repository.deleteById(id);
    }

    /**
     * get posting by id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Optional<Posting> getPostingById(@PathVariable String id){
        return repository.findById(id);
    }
}
