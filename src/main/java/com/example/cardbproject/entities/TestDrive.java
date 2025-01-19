package com.example.cardbproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "test_drives")
public class TestDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_test_drive;

    @Column(name = "id_car", nullable = false)
    private int idCar;

    @Column(name = "id_employee", nullable = false)
    private int idEmployee;

    @Column(name = "id_client", nullable = false)
    private int idClient;

    @Column(name = "test_date", nullable = false)
    private LocalDate testDate;

    @Column(nullable = false)
    private float duration;
}
