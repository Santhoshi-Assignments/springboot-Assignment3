package com.app.service;

import com.app.entity.Address;
import com.app.entity.Employee;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        // Set the employee object for each address before saving
        List<Address> addresses = employee.getAddresses();
        if (addresses != null) {
            for (Address address : addresses) {
                address.setEmployee(employee);
            }
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        // Set the employee object for each address before updating
        List<Address> addresses = employee.getAddresses();
        if (addresses != null) {
            for (Address address : addresses) {
                address.setEmployee(employee);
            }
        }
        employee.setEmployeeId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesOrderedByName() {
        return employeeRepository.findAllByOrderByName();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return employee;
    }
    @Override
    public Page<Employee> getEmployeesByDepartment(String department, Pageable pageable) {
        logger.info("Fetching employees by department: {}", department);
        return employeeRepository.findByDepartment(department, pageable);
    }
}
