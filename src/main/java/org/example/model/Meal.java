package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Блюда")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД")
    private Long id;

    @Column(name = "Название")
    private String name;

    @Column(name = "Калории_на_порцию")
    private Integer caloriesPerServing;

    @Column(name = "Белки")
    private Double proteins;

    @Column(name = "Жиры")
    private Double fats;

    @Column(name = "Углеводы")
    private Double carbs;
}
