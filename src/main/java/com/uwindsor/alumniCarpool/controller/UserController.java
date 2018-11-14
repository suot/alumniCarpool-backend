package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.User;
import com.uwindsor.alumniCarpool.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin
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
     * upload avatar to server path: ~/static/images/{id}
     * @param
     */
    @PostMapping("/upload/avatar")
    public void uploadAvatar(@RequestParam String id, @RequestParam MultipartFile file) throws IOException {
        //create a folder
        String userIdPath = UserController.class.getResource("/").getPath() + "static/images/" + id;
        File userIdDir = new File(userIdPath);
        if(!userIdDir.exists()){
            userIdDir.mkdirs();
        }

        File avatar = new File(userIdDir + "/avatar.jpg");
        OutputStream os = new FileOutputStream(avatar);
        os.write(file.getBytes());
        os.close();
    }



    /**
     * modify a user
     */
    @PostMapping("/update")
    public void updateUserById(@RequestBody User user){
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


    /**
     * get User by email
     * @param email
     * @return
     */
    @GetMapping("/get")
    public User getUserByEmail(@RequestParam String email){
        Optional<List<User>> userList = repository.getUserByEmail(email);
        if(userList.isPresent()){
            return userList.get().get(0);
        }else {
            return null;
        }
    }

}
