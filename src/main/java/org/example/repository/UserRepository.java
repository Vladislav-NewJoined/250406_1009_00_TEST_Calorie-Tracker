package org.example.repository;

import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM User")
    void deleteAllUsers();

    @Modifying
    @Transactional
    @Query("INSERT INTO User (name, email, goal, height, weight, activityLevel, gender) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)")
    void addUser(String name, String email, String goal, double height, double weight, String activityLevel, String gender);
}
