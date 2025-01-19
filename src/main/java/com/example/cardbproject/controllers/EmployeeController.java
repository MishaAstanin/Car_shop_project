package com.example.cardbproject.controllers;

import com.example.cardbproject.entities.Car;
import com.example.cardbproject.entities.Employee;
import com.example.cardbproject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @GetMapping("/{id_employee}")
    public String getEmployee(@PathVariable Integer id_employee, Model model) {
        List<Car> cars =  employeeService.findCarsByEmployee(id_employee);
        Employee employee = employeeService.getById(id_employee);
        model.addAttribute("cars", cars);
        model.addAttribute("employee", employee);
        return "employee-detail";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "create-employee";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        try {
            if (Objects.equals(employee.getPatronymic(), "")) {
                employee.setPatronymic(null);
            }
            employeeService.add(employee);
            return "redirect:/employees/all";
        } catch (Exception e) {
            return "redirect:/employees/fail";
        }
    }

    @GetMapping("/fail")
    public String failEmployee() {
        return "fail-create-employee";
    }

    @PostMapping("/delete-employee/{id_employee}")
    public String deleteEmployee(@PathVariable Integer id_employee) {
        employeeService.delete(id_employee);
        return "redirect:/employees/all";
    }
}
