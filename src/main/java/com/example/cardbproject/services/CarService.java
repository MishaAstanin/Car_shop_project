package com.example.cardbproject.services;

import com.example.cardbproject.entities.Car;
import com.example.cardbproject.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car> getAll(String sortBy, String orderBy) {
        Sort sort = Sort.by(sortBy);
        if (!orderBy.equalsIgnoreCase("asc")) {
            sort = sort.descending();
        }
        return carRepository.findAll(sort);
    }

    public Car getById(int id_car) {
        return carRepository.findById(id_car).orElse(null);
    }

    public float getAvgPrice() {
        return carRepository.getAvgCarsPrice();
    }

    public int getCountByEngine(String en_type) {
        return carRepository.getCountCarByTypeEngine(en_type);
    }

    public boolean checkIsBought(int id_car) {
        return carRepository.checkIfCarIsBought(id_car);
    }

    public int getCountByYear(int year) {
        return carRepository.getCountCarByYear(year);
    }

    public String getShortInfo(int id_car) {
        return carRepository.getShortCarInfo(id_car);
    }
}
