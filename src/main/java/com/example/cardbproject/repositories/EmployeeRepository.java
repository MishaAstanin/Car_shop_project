package com.example.cardbproject.repositories;

import com.example.cardbproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "CALL test_drive_car_by_employee(:id)", nativeQuery = true)
    Object[] findCarsByEmployeeId(@Param("id") int id);
}
