package org.example.repository;

import org.example.model.MealEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealEntryRepository extends JpaRepository<MealEntry, Long> {
    List<MealEntry> findByUserIdAndDate(Long userId, LocalDate date);
}
