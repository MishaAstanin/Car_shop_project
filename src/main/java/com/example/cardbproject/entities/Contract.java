package com.example.cardbproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "form_payment", nullable = false)
    private String formPayment;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "pasport_series", nullable = false)
    private String passportSeries;

    @Column(name = "pasport_number", nullable = false)
    private String passportNumber;

    @Column(name = "id_client", nullable = false)
    private int clientId;

    @Column(name = "id_employee", nullable = false)
    private int employeeId;

    @Column(name = "id_car", nullable = false)
    private int carId;
}
