package com.francofitness.calorietracker.repositories;

import com.francofitness.calorietracker.models.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    List<Athlete> findAllByActivityLevel(String activityLevel);

}
