package com.example.spendingz2.controllers;

import com.example.spendingz2.entities.User;
import com.example.spendingz2.repos.UserRepository;
import com.example.spendingz2.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @GetMapping("/{uid}")
    public User findUserByID(@PathVariable Long uid){
        return userService.findUserByID(uid);
    }

    @PutMapping("/{uid}")
    public User updateUserByID(@PathVariable Long uid, @RequestBody User updateUser){
        return userService.updateUserByID(uid, updateUser);
    }

    @DeleteMapping("/{uid}")
    public void deleteUserByID(@PathVariable Long uid){
        userService.deleteUserByID(uid);
    }
}
