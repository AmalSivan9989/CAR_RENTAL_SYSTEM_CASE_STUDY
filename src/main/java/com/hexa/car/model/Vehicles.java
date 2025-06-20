package com.hexa.car.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "vehicles")
public class Vehicles {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String model;
    private String location;
    private double pricePerDay;

    @Enumerated(EnumType.STRING)
    private VehicleAvailability availability;
}