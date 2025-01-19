package com.example.cardbproject.repositories;

import com.example.cardbproject.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query(value = "SELECT avg_cars_price()", nativeQuery = true)
    float getAvgCarsPrice();

    @Query(value = "CALL get_count_car_by_type_engine(:en_type)", nativeQuery = true)
    int getCountCarByTypeEngine(@Param("en_type") String en_type);

    @Query(value = "SELECT car_is_bought(:id)", nativeQuery = true)
    boolean checkIfCarIsBought(@Param("id") int id);

    @Query(value = "SELECT get_cars_by_year(:year)", nativeQuery = true)
    int getCountCarByYear(@Param("year") int year);

    @Query(value = "SELECT get_short_info_car(:id)", nativeQuery = true)
    String getShortCarInfo(@Param("id") int id);
}
