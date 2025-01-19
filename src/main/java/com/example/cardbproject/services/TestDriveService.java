package com.example.cardbproject.services;

import com.example.cardbproject.entities.TestDrive;
import com.example.cardbproject.repositories.TestDriveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDriveService {
    private final TestDriveRepository testDriveRepository;

    @Autowired
    public TestDriveService(TestDriveRepository testDriveRepository) {
        this.testDriveRepository = testDriveRepository;
    }

    public List<TestDrive> getAll() {
        return testDriveRepository.findAll();
    }

    public TestDrive getById(int id_test_drive) {
        return testDriveRepository.findById(id_test_drive).orElse(null);
    }

    public List<TestDrive> get2024TestDrives() {
        return testDriveRepository.getTestsIn2024();
    }

    public TestDrive add(TestDrive testDrive) {
        return testDriveRepository.save(testDrive);
    }

    public void delete(int id_test_drive) {
        testDriveRepository.deleteById(id_test_drive);
    }
}
