package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Min(1)
    @Max(120)
    private int age;

    @Min(1)
    private double weight; // в кг

    @Min(1)
    private double height; // в см

    @Enumerated(EnumType.STRING)
    private Goal goal;

    private double dailyCalorieIntake; // Рассчитывается автоматически

    public enum Goal {
        LOSE_WEIGHT, MAINTAIN_WEIGHT, GAIN_WEIGHT
    }
}
