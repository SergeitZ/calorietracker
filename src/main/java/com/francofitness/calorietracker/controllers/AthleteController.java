package com.francofitness.calorietracker.controllers;

import com.francofitness.calorietracker.models.Athlete;
import com.francofitness.calorietracker.repositories.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/athletes")
public class AthleteController {
    @Autowired
    private AthleteRepository athleteRepository;

//    @Autowired
//    private ExerciseRepository exerciseRepository;

    @GetMapping
    public @ResponseBody List<Athlete> getAthletes() {
        return athleteRepository.findAll();
    }

    @GetMapping("/activity/{activityLevel}")
    public List<Athlete> getAthleteByActiviyLevel (@PathVariable String activityLevel) {
        return athleteRepository.findAllByActivityLevel(activityLevel);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Athlete getOneAthlete (@PathVariable Long id) {
        return athleteRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Athlete> createAthlete (@RequestBody Athlete newAthlete) {
        return new ResponseEntity<> (athleteRepository.save(newAthlete), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Athlete updateUser (@PathVariable Long id, @RequestBody Athlete updates) {
        Athlete athlete = athleteRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getActivityLevel() != null) athlete.setActivityLevel(updates.getActivityLevel());
        if (updates.getWeightGoal() != null) athlete.setWeightGoal(updates.getWeightGoal());

        return athleteRepository.save(athlete);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteAthlete(@PathVariable Long id) {
        athleteRepository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
