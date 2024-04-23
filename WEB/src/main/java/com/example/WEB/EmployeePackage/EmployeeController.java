package com.example.WEB.EmployeePackage;

import com.example.WEB.ProposalPackage.ProposalRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository, ProposalRepository proposalRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee/all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

}
