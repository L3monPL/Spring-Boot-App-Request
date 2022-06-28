package com.example.springbootjava.service;

import com.example.springbootjava.entity.User;
import com.example.springbootjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user){
        return repository.save(user);
    }
    public List<User> getUsers(){
        return repository.findAll();
    }
    public User getUserById(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteUser(int id){
        repository.deleteById(id);
        return "user removed!" + id;
    }
    public User updateUser(User user, int id){
        User existingUser=repository.findById(id).orElse(null);
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        return repository.save(existingUser);
    }
}
