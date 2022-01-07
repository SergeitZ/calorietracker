package com.francofitness.calorietracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long age;
    private Long weight;
    private Long weighGoal;
    private String activityLevel; //Levels: Sedentary, Lightly active, Moderately active,Very active

    public User() {}

    public User(String name, Long age, Long weight, Long weighGoal, String activityLevel) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.weighGoal = weighGoal;
        this.activityLevel = activityLevel;
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

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getWeighGoal() {
        return weighGoal;
    }

    public void setWeighGoal(Long weighGoal) {
        this.weighGoal = weighGoal;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
}
