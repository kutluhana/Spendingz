package com.example.spendingz2.services;

import com.example.spendingz2.entities.User;
import com.example.spendingz2.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    public User findUserByID(@PathVariable Long uid){
        return userRepository.findById(uid).orElse(null);
    }


    public User updateUserByID(Long uid, User updateUser) {
        Optional<User> user = userRepository.findById(uid);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setEmail(updateUser.getEmail());
            foundUser.setPassword(updateUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        } else{
            return null;
        }
    }

    public void deleteUserByID(Long uid){
        userRepository.deleteById(uid);
    }
}
