package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable @Validated String id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody @Validated User user){
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody @Validated User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Validated String id){
        userService.deleteUser(id);
    }

    @GetMapping("/search/name/{name}")
    public List<User> getUserByName(@PathVariable @Validated String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/search/age/{age}")
    public List<User> getUserByAge(@PathVariable @Validated int age){
        return userService.getUserByAge(age);
    }
}
