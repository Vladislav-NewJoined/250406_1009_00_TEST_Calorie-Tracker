package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Пользователи") // Явное указание имени таблицы
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @Email(message = "Некорректный email")
    @NotBlank(message = "Email не может быть пустым")
    private String email;

    @Min(value = 1, message = "Возраст должен быть больше 0")
    @Max(value = 120, message = "Возраст должен быть меньше 120")
    private int age;

    @Min(value = 1, message = "Вес должен быть больше 0")
    private double weight; // в кг

    @Min(value = 1, message = "Рост должен быть больше 0")
    private double height; // в см

    @Enumerated(EnumType.STRING)
    private Goal goal;

    @Transient
    private double dailyCalorieIntake; // Рассчитывается автоматически

    public User() {
    }

    public User(String name, String email, int age, double weight, double height, Goal goal) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.goal = goal;
    }

    public enum Goal {
        LOSE_WEIGHT, MAINTAIN_WEIGHT, GAIN_WEIGHT
    }
}
