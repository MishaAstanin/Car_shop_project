package com.example.cardbproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_client;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String name;

    @Column()
    private String patronymic;

    @Column(nullable = false)
    private String phone;

    @Column()
    private String email;

    @Column(nullable = false)
    private LocalDate birthday;
}
