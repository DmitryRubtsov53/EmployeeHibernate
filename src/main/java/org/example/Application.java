package org.example;

import org.example.model.City;
import org.example.model.Employee;
import org.example.service.EmployeeDAO;
import org.example.service.EmployeeDAOImpl;

import java.sql.SQLException;

import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

            List<Employee> employeeList;
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();

            Employee Nikolay = new Employee("Nikolay","Orlov","male",27,5);
            employeeDAO.createEmployee(Nikolay);

            System.out.println("----------------------------------------------------------");
            System.out.println(employeeDAO.readById(5));

            System.out.println("----------------------------------------------------------");
            employeeList = employeeDAO.readAllEmployee();
            for (Employee el : employeeList) {
                    System.out.println(el);
            }
            System.out.println("----------------------------------------------------------");
            Nikolay.setFirstName("Sokolov");
            employeeDAO.updateEmployee(Nikolay);
            System.out.println(employeeDAO.readById(12));

            System.out.println("----------------------------------------------------------");
            employeeDAO.deleteEmployee(Nikolay);
            employeeList = employeeDAO.readAllEmployee();
            for (Employee el : employeeList) {
                System.out.println(el);
            }
    }
}
