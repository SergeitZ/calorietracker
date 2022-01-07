package com.francofitness.calorietracker.repositories;

import com.francofitness.calorietracker.models.Exercise;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByType(String type, Sort sort);
}
