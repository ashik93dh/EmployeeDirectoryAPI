package com.example.employeedirectoryapi.restcontroller;

import com.example.employeedirectoryapi.entity.Employee;
import com.example.employeedirectoryapi.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee employee= employeeService.findById(employeeId);

        if (employee==null){
            throw new RuntimeException("No employee found with id"+employeeId);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee=employeeService.save(employee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee=employeeService.save(employee);
        return dbEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee=employeeService.findById(employeeId);
        if (employee==null){
            throw new RuntimeException("No employee found with id "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee deleted with id "+employeeId;
    }
}
