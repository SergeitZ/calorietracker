package com.francofitness.calorietracker.repositories;

import com.francofitness.calorietracker.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
