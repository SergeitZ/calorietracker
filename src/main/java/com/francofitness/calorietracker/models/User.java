package com.francofitness.calorietracker.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "athlete")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Long age;
    private Long weight;
    private Long weightGoal;
    private String activityLevel; //Levels: Sedentary, Light, Moderately active,Very active

    public User() {}

    public User(String name, Long age, Long weight, Long weighGoal, String activityLevel) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.weightGoal = weighGoal;
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

    public Long getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(Long weightGoal) {
        this.weightGoal = weightGoal;
    }

    public String getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
}
