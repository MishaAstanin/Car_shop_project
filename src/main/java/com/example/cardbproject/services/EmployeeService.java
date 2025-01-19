package com.example.cardbproject.services;

import com.example.cardbproject.entities.Car;
import com.example.cardbproject.entities.Employee;
import com.example.cardbproject.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(int id_employee) {
        return employeeRepository.findById(id_employee).orElse(null);
    }

    public List<Car> findCarsByEmployee(Integer id_employee) {
        Object[] source = employeeRepository.findCarsByEmployeeId(id_employee);
        List<Car> cars = new ArrayList<>();
        for (Object obj : source) {
            if (obj instanceof Object[] row) {
                Car car = new Car();
                car.setId_car((int) row[0]);
                car.setVin((String) row[1]);
                car.setBrand((String) row[2]);
                car.setModel((String) row[3]);
                car.setColor((String) row[4]);
                car.setPrice((float) row[5]);
                car.setYear((int) row[6]);
                car.setEquipment((String) row[7]);
                car.setTypeDriveUnit((String) row[8]);
                car.setEngineCapacity((float) row[9]);
                car.setTypeEngine((String) row[10]);
                car.setTypeBody((String) row[11]);
                car.setTypeBox((String) row[12]);
                cars.add(car);
            }
        }
        return cars;
    }

    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void delete(Integer id_employee) {
        employeeRepository.deleteById(id_employee);
    }
}
