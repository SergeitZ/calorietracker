package com.francofitness.calorietracker.controllers;

import com.francofitness.calorietracker.models.User;
import com.francofitness.calorietracker.repositories.ExerciseRepository;
import com.francofitness.calorietracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private ExerciseRepository exerciseRepository;

    @GetMapping
    public @ResponseBody List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/activity/{activityLevel}")
    public List<User> getUsersByActiviyLevel (@PathVariable String activityLevel) {
        return userRepository.findAllByActivityLevel(activityLevel);
    }

    @GetMapping("/{id}")
    public @ResponseBody User getOneUser (@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User newUser) {
        return new ResponseEntity<> (userRepository.save(newUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
