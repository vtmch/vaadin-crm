package com.vaadin.tutorial.crm.backend.service;

import com.vaadin.tutorial.crm.backend.entity.Employee;
import com.vaadin.tutorial.crm.backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class EmployeeService {

    private static final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Employee employee) {

        if (employee == null) {
            LOGGER.log(Level.SEVERE,
                    "Employee is null. Are you sure you have connected your form to the application?");
            return;
        }

        employeeRepository.save(employee);
    }
}