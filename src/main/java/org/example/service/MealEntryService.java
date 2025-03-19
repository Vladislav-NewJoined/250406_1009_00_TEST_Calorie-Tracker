package org.example.service;

import org.example.model.MealEntry;
import org.example.repository.MealEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MealEntryService {
    @Autowired
    private MealEntryRepository mealEntryRepository;

    public MealEntry addMealEntry(MealEntry mealEntry) {
        mealEntry.setDate(LocalDate.now());
        return mealEntryRepository.save(mealEntry);
    }

    public List<MealEntry> getDailyMealEntries(Long userId, LocalDate date) {
        return mealEntryRepository.findByUserIdAndDate(userId, date);
    }
}
