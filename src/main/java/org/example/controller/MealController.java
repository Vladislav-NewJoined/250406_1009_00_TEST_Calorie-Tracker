package org.example.controller;

import org.example.model.Meal;
import org.example.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        return mealService.addMeal(meal);
    }
}
