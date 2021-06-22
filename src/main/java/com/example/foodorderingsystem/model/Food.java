package com.example.foodorderingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="food")
@Table(name="food")
public class Food {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(45)")
        private String name;

        @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(45)")
        private String description;

        @Column(name = "price", nullable = false, columnDefinition = "VARCHAR(45)")
        private Double price;

        @OneToMany(mappedBy = "food", cascade = CascadeType.REMOVE)
        private List<Cart> cart;




}
