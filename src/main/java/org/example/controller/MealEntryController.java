package org.example.controller;

import org.example.model.MealEntry;
import org.example.service.MealEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/meal-entries")
public class MealEntryController {
    @Autowired
    private MealEntryService mealEntryService;

    @PostMapping
    public MealEntry addMealEntry(@RequestBody MealEntry mealEntry) {
        return mealEntryService.addMealEntry(mealEntry);
    }

    @GetMapping("/daily")
    public List<MealEntry> getDailyMealEntries(@RequestParam Long userId, @RequestParam LocalDate date) {
        return mealEntryService.getDailyMealEntries(userId, date);
    }
}
