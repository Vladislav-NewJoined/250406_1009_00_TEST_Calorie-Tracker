package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Пользователи") // Имя таблицы на кириллице
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") // Имя столбца на английском (H2 не поддерживает кириллицу для ID)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    @Column(name = "Имя") // Имя столбца на кириллице
    private String name;

    @Email(message = "Некорректный email")
    @NotBlank(message = "Email не может быть пустым")
    @Column(name = "Email") // Имя столбца на кириллице
    private String email;

    @Min(value = 1, message = "Возраст должен быть больше 0")
    @Max(value = 120, message = "Возраст должен быть меньше 120")
    @Column(name = "Возраст") // Имя столбца на кириллице
    private int age;

    @Min(value = 1, message = "Вес должен быть больше 0")
    @Column(name = "Вес (кг)") // Имя столбца на кириллице
    private double weight;

    @Min(value = 1, message = "Рост должен быть больше 0")
    @Column(name = "Рост (см)") // Имя столбца на кириллице
    private double height;

    @Enumerated(EnumType.STRING)
    @Column(name = "Цель") // Имя столбца на кириллице
    private Goal goal;

    @Transient // Вычисляемое поле, не сохраняется в БД
    private double dailyCalorieIntake;

    public enum Goal {
        LOSE_WEIGHT, MAINTAIN_WEIGHT, GAIN_WEIGHT
    }
}
