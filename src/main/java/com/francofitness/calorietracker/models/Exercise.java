package com.francofitness.calorietracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    private Long volume;
    private Long reps;

    public Exercise() {}

    public Exercise(String name, Long volume, Long reps, String type) {
        this.name = name;
        this.volume = volume;
        this.reps = reps;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public Long getReps() {
        return reps;
    }

    public void setReps(Long reps) {
        this.reps = reps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
