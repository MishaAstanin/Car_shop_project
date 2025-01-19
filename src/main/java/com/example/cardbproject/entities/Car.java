package com.example.cardbproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_car;

    @Column(nullable = false, unique = true)
    private String vin;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private String equipment;

    @Column(name = "type_drive_unit", nullable = false)
    private String typeDriveUnit;

    @Column(name = "engine_capacity")
    private float engineCapacity;

    @Column(name = "type_engine", nullable = false)
    private String typeEngine;

    @Column(name = "type_body", nullable = false)
    private String typeBody;

    @Column(name = "type_box", nullable = false)
    private String typeBox;
}
