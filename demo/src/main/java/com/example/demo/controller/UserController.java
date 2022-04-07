package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
//@RequestMapping(path = "/todo")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //GET ALL
    @GetMapping(path = "/todo")
    public List<User> getUser(){
        return userService.getUser();
    }
    //GET by ID
    @GetMapping(path = "todo/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Long userId){
        return userService.getUserById(userId);
    }
    //ADD
    @PostMapping(path = "/todo")
    public void addNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
    //DELETE BY ID
    @DeleteMapping(path = "todo/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);

    }
    //UPDATE BY ID
    @PutMapping(path = "todo/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String targetDate){
        userService.updateUser(userId, username, description, targetDate);

    }



}
