package com.leobrambilla.medicalshop.domain.address;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Street is required")
    private String street;

    @NotNull(message = "Number is required")
    private int number;

    @NotNull(message = "Neighborhood is required")
    private String neighborhood;

    @NotNull(message = "City is required")
    private String city;

    @NotNull(message = "State is required")
    private String state;

    @NotNull(message = "Zip code is required")
    private String zipCode;
}
