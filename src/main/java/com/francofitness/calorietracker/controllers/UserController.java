package com.francofitness.calorietracker.controllers;

import com.francofitness.calorietracker.models.User;
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
    private UserRepository repository;

//    @Autowired
//    private ExerciseRepository exerciseRepository;

    @GetMapping
    public @ResponseBody List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/activity/{activityLevel}")
    public List<User> getUsersByActiviyLevel (@PathVariable String activityLevel) {
        return repository.findAllByActivityLevel(activityLevel);
    }

    @GetMapping("/{id}")
    public @ResponseBody User getOneUser (@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser (@RequestBody User newUser) {
        return new ResponseEntity<> (repository.save(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public User updateUser (@PathVariable Long id, @RequestBody User updates) {
        User user = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getActivityLevel() != null) user.setActivityLevel(updates.getActivityLevel());
        if (updates.getWeightGoal() != null) user.setWeightGoal(updates.getWeightGoal());

        return repository.save(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
