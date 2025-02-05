package com.example.cardbproject.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
