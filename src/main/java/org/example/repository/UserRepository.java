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
    @Query(value = "ALTER TABLE ПОЛЬЗОВАТЕЛИ ALTER COLUMN ID RESTART WITH 1", nativeQuery = true)
    void resetIdSequence();
}
