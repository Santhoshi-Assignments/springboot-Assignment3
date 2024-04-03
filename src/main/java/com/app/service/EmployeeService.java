package com.app.service;
import com.app.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
    List<Employee> getAllEmployeesOrderedByName();
    Employee getEmployeeById(Long id);

    Page<Employee> getEmployeesByDepartment(String department, Pageable pageable);
}
