package com.example.fantasy_football.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "Players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    @NotBlank(message = "First name can't be empty")
    @Size(min=2, max = 50, message = "Name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name can't be empty")
    @Size(min=2, max = 50, message = "Name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Club name can't be empty")
    private String club;

    @NotBlank(message = "Nationality can't be empty")
    private String nationality;

    @NotNull(message = "Position is required")
    @Enumerated(EnumType.STRING)
    private String position;

    @Min(value=1,message="Jersey number must be at least 1")
    @Max(value = 99, message = "Jersey number can't exceed 99")
    private Integer jerseyNumber;

    @DecimalMin(value = "0.0",inclusive = true,message = "Market value can't be negative")
    private BigDecimal marketValue;
}
