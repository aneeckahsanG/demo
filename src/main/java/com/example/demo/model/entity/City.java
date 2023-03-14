package com.example.demo.model.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is mandatory")
    @Column(unique = true)
    private String name;

//    @Range(min=10, max=100_000_000, message = "population should be between 10 and 100_000_000")
    @Min(value = 10, message = "population should be between 10 and 100_000_000")
    @Max(value = 100000000, message = "population should be between 10 and 100_000_000")
    private int population;

    public City(@NotEmpty String name, @Min(value = 10) @Max(value = 100_000_000) int population) {
        this.name = name;
        this.population = population;
    }
}
