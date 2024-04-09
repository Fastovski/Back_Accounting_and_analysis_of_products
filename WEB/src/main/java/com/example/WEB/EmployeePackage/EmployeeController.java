package com.example.WEB.EmployeePackage;

import com.example.WEB.PassEncoder.Hash;
import com.example.WEB.UserPackage.Role;
import com.example.WEB.UserPackage.User;
import com.example.WEB.UserPackage.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")

public class EmployeeController {

    private final UserRepository userRepository;

    private final EmployeeRepository employeeRepository;

    public EmployeeController(UserRepository userRepository, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee/all")
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employee/add")
    public void newEmployee(@RequestBody User user){
        Employee employee = new Employee();
        employee.setOperation(0);
        employee.setUserId(user);
        user.setPassword(Hash.HashPassword(user.getPassword()));
        user.setRole(Role.Employee);
        user.setEmployeeId(employee);
        userRepository.save(user);
    }
    @Transactional
    @PutMapping("/employee/update/{id}")
    public void updateEmployee(@PathVariable("id") Integer id, @RequestBody User user){
        userRepository.update(id,user.getName(), user.getEmail());
    }
    @Transactional
    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
    @GetMapping("/employee/one/{id}")
    public User getOne(@PathVariable("id") Integer id){
        return userRepository.findById(id).orElse(null);
    }
}
