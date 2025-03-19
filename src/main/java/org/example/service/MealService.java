package org.example.service;

import org.example.model.Meal;
import org.example.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }
}
