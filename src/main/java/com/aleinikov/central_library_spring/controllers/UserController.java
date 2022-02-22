package com.aleinikov.central_library_spring.controllers;

import com.aleinikov.central_library_spring.entities.User;
import com.aleinikov.central_library_spring.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public UserDetails findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public UserDetails saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/user/{id}")
    public UserDetails updateUser(@RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User was deleted", HttpStatus.NO_CONTENT);
    }
}
