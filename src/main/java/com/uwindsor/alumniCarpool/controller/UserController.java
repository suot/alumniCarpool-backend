package com.uwindsor.alumniCarpool.controller;

import com.uwindsor.alumniCarpool.model.User;
import com.uwindsor.alumniCarpool.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * create a new user
     * @param user
     */
    @PostMapping("/create")
    public void createUser(@RequestBody User user){
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        repository.save(user);
    }


    /**
     * upload avatar to server path: ~/static/images/{id}
     * @param
     */
    @PostMapping("/upload/avatar")
    public void uploadAvatar(@RequestParam String id, @RequestParam MultipartFile file) throws IOException {
        //@RequestParam MultipartFile file: here file should be the same with frontend: formData.append('file', fileUploading);
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


    @PostMapping("/upload/car")
    public void uploadCar(@RequestParam String id, @RequestParam MultipartFile file) throws IOException {
        //@RequestParam MultipartFile file: here file should be the same with frontend: formData.append('file', fileUploading);
        //create a folder
        String userIdPath = UserController.class.getResource("/").getPath() + "static/images/" + id;
        File userIdDir = new File(userIdPath);
        if(!userIdDir.exists()){
            userIdDir.mkdirs();
        }

        File avatar = new File(userIdDir + "/car.jpg");
        OutputStream os = new FileOutputStream(avatar);
        os.write(file.getBytes());
        os.close();
    }


    @PostMapping("/upload/certificate")
    public void uploadCertificate(@RequestParam String id, @RequestParam MultipartFile file) throws IOException {
        //@RequestParam MultipartFile file: here file should be the same with frontend: formData.append('file', fileUploading);
        //create a folder
        String userIdPath = UserController.class.getResource("/").getPath() + "static/images/" + id;
        File userIdDir = new File(userIdPath);
        if(!userIdDir.exists()){
            userIdDir.mkdirs();
        }

        File avatar = new File(userIdDir + "/certificate.jpg");
        OutputStream os = new FileOutputStream(avatar);
        os.write(file.getBytes());
        os.close();
    }



    /**
     * modify a user
     */
    @PutMapping("/update")
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
    public User getUserByEmail(@RequestParam String email, @RequestParam String password){
        List<User> userList = repository.getUserByEmail(email);

        if(userList == null || userList.isEmpty()){
            return null;
        }else {
            User user = userList.get(0);
            if(passwordEncoder.matches(password, user.getPassword())) {
                //add token to user
            }else{
                user.setPassword("");
            }
            return user;
        }
    }


}
