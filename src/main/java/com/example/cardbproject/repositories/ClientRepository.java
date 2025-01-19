package com.example.cardbproject.repositories;

import com.example.cardbproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
