package com.example.demo.controller;

import com.example.demo.dao.UserRequestDto;
import com.example.demo.models.User;
import com.example.demo.services.bll.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody UserRequestDto userDto){
        var user = userDto.getUser();
        return userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public User addUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public List<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return userService.getAll();
    }
}
