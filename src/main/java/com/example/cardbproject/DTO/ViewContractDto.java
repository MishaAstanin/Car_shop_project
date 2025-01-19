package com.example.cardbproject.DTO;

import java.time.LocalDate;

public interface ViewContractDto {
    int getNumber();
    LocalDate getDate();
    String getSurname();
    String getName();
    String getPatronymic();
    String getBrand();
    String getModel();
    String getColor();
    float getPrice();
    int getYear();
}
