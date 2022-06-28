package com.example.springbootjava.controller;

import com.example.springbootjava.entity.User;
import com.example.springbootjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "CREATED")
    public User addUser(@RequestBody User user){
        return service.saveUser(user);
    }
    @GetMapping("/user")
    public List<User> findAllUsers(){
        return service.getUsers();
    }
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user,@PathVariable int id){
        return service.updateUser(user,id);
    }
    @DeleteMapping("/user/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "NO_CONTENT")
    public String deleteUser(@PathVariable int id){
        return service.deleteUser(id);
    }
    //additionally outside the task
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id);
    }

}
