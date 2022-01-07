package com.francofitness.calorietracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class Result {
    @Id
    @GeneratedValue
    private Long id;
    private Long caloriesBurned;
    private Integer timeTaken;
    private Long caloriesRemaining;

    public Result() {
    }

    public Result(Long caloriesBurned, Integer timeTaken, Long caloriesRemaining) {
        this.caloriesBurned = caloriesBurned;
        this.timeTaken = timeTaken;
        this.caloriesRemaining = caloriesRemaining;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Long caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Integer getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Integer timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Long getCaloriesRemaining() {
        return caloriesRemaining;
    }

    public void setCaloriesRemaining(Long caloriesRemaining) {
        this.caloriesRemaining = caloriesRemaining;
    }
}
