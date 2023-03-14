package org.example.service;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    // Добавление объекта
    void createEmployee(Employee employee);
    // Получение объекта по id
    Employee readById(int id);

    List<Employee> readAllEmployee();

    void updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}