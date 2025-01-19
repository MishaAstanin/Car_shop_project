package com.example.cardbproject.controllers;

import com.example.cardbproject.entities.TestDrive;
import com.example.cardbproject.services.TestDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestDriveController {
    private final TestDriveService testDriveService;

    @Autowired
    public TestDriveController(TestDriveService testDriveService) {
        this.testDriveService = testDriveService;
    }

    @GetMapping("/all")
    public String getAllTests(Model model) {
        List<TestDrive> tests = testDriveService.getAll();
        model.addAttribute("tests", tests);
        return "tests";
    }

    @GetMapping("/{id_test_drive}")
    public @ResponseBody TestDrive getTest(@PathVariable Integer id_test_drive) {
        return testDriveService.getById(id_test_drive);
    }

    @GetMapping("/2024")
    public String get2024Tests(Model model) {
        List<TestDrive> tests =  testDriveService.get2024TestDrives();
        model.addAttribute("tests", tests);
        return "tests";
    }

    @GetMapping("/add/{id_car}")
    public String addTestDrive(@PathVariable Integer id_car, Model model) {
        model.addAttribute("test", new TestDrive());
        model.addAttribute("id_car", id_car);
        return "create-test";
    }


    @PostMapping("/add/{id_car}")
    public String addTestDrive(@ModelAttribute TestDrive test, @PathVariable Integer id_car) {
        try {
            test.setIdCar(id_car);
            testDriveService.add(test);
            return "redirect:/tests/all";
        } catch (Exception e) {
            return "redirect:/tests/fail";
        }
    }

    @GetMapping("/fail")
    public String failTest() {
        return "fail-create-test";
    }

    @PostMapping("/delete-test/{id_test_drive}")
    public String deleteTest(@PathVariable Integer id_test_drive) {
        testDriveService.delete(id_test_drive);
        return "redirect:/tests/all";
    }
}
