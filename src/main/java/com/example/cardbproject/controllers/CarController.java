package com.example.cardbproject.controllers;

import com.example.cardbproject.entities.Car;
import com.example.cardbproject.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public String getAllCars(Model model,
                             @RequestParam(defaultValue = "brand") String sortBy,
                             @RequestParam(defaultValue = "asc") String orderBy) {
        List<Car> cars = carService.getAll(sortBy, orderBy);
        float avg = carService.getAvgPrice();
        model.addAttribute("cars", cars);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("orderBy", orderBy);
        model.addAttribute("avg", avg);
        model.addAttribute("service", carService);
        return "cars";
    }

    @GetMapping("/{id_car}")
    public String getCar(@PathVariable Integer id_car, Model model) {
        Car car = carService.getById(id_car);
        String info = carService.getShortInfo(id_car);
        Boolean is_bought = carService.checkIsBought(id_car);
        model.addAttribute("car", car);
        model.addAttribute("info", info);
        model.addAttribute("is_bought", is_bought);
        model.addAttribute("service", carService);
        return "car-detail";
    }
}
