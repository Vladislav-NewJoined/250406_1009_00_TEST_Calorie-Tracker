package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "БЛЮДА")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ИД")
    private Long id;

    @Column(name = "НАЗВАНИЕ")
    private String name;

    @Column(name = "КАЛОРИИ_НА_ПОРЦИЮ")
    private Integer caloriesPerServing;

    @Column(name = "БЕЛКИ")
    private Double proteins;

    @Column(name = "ЖИРЫ")
    private Double fats;

    @Column(name = "УГЛЕВОДЫ")
    private Double carbs;
}
