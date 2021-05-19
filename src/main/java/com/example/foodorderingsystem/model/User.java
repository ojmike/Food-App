package com.example.foodorderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="users")
@Table(name="users")
public class User {
    @Id

    @GeneratedValue(strategy  = SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstName", nullable = false, columnDefinition = "VARCHAR(45)")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "VARCHAR(45)")
    private String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(45)")
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(45)")
    private String password;

    @Column(name = "address", nullable = false, columnDefinition = "VARCHAR(45)")
    private String address;
}
