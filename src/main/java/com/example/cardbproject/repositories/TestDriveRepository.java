package com.example.cardbproject.repositories;

import com.example.cardbproject.entities.TestDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestDriveRepository extends JpaRepository<TestDrive, Integer> {
    @Query(value = "CALL tests_in_2024()", nativeQuery = true)
    List<TestDrive> getTestsIn2024();
}
