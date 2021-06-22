package com.example.foodorderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="restaurant")
@Table(name="restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy  = SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "restaurantName", nullable = false, columnDefinition = "VARCHAR(45)")
    private String restaurantName;

    @Column(name = "phoneNumber", nullable = false, columnDefinition = "VARCHAR(45)")
    private String phoneNumber;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(45)")
    private String password;

    @Column(name = "website", nullable = false, columnDefinition = "VARCHAR(45)")
    private String website;

    @Column(name = "firstName", nullable = false, columnDefinition = "VARCHAR(45)")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "VARCHAR(45)")
    private String lastName;

    @Column(name = "location", nullable = false, columnDefinition = "VARCHAR(45)")
    private String location;
}
