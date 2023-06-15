package com.example.employeedirectoryapi.service;

import com.example.employeedirectoryapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);
    Employee save(Employee employee);

    void deleteById(int id);
}
