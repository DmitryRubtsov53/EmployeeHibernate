package org.example;

import org.example.model.City;
import org.example.model.Employee;
import org.example.service.CityDAO;
import org.example.service.CityDAOImpl;
import org.example.service.EmployeeDAO;
import org.example.service.EmployeeDAOImpl;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {

            List<Employee> employeeList = new ArrayList<>();
            List<City> cityList = new ArrayList<>();
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            CityDAO cityDAO = new CityDAOImpl();



            City Rostov = new City("Rostov-na-Donu");
            cityDAO.createCity(Rostov);
            City Ufa = new City("Ufa");
            cityDAO.createCity(Ufa);
            City Omsk = new City("Omsk");
            cityDAO.createCity(Omsk);
            City Birsk = new City("Birsk");
            cityDAO.createCity(Birsk);
            City Orsha = new City("Orsha");
            cityList.add(Orsha);
            cityDAO.createCity(Orsha);
            City Lida = new City("Lida");
            cityDAO.createCity(Lida);
            City Asha = new City("Asha");
            cityDAO.createCity(Asha);

            Employee Artem = new Employee("Artem","Yanpolsky","male",24,Rostov);
            employeeDAO.createEmployee(Artem);
            Employee Oleg = new Employee("Oleg","Ivanov","male",27,Ufa);
            employeeDAO.createEmployee(Oleg);
            Employee Olga = new Employee("Olga","Ivanova","woman",23,Ufa);
            employeeDAO.createEmployee(Olga);
            Employee Petr = new Employee("Petr","Ivanov","male",30,Omsk);
            employeeDAO.createEmployee(Petr);
            Employee Igor = new Employee("Igor","Igorev","male",35,Birsk);
            employeeDAO.createEmployee(Igor);
            Employee Sasha = new Employee("Sasha","Antonov","male",30,Orsha);
            employeeDAO.createEmployee(Sasha);
            Employee Dasha = new Employee("Dasha","Lomova","woman",35,Asha);
            employeeDAO.createEmployee(Dasha);

            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println(employeeDAO.readById(3));
            System.out.println(cityDAO.readById(2));

            System.out.println("-------------------------------------------------------------------------------------");
            employeeList = employeeDAO.readAllEmployee();
            for (Employee el : employeeList) {
                    System.out.println(el);
            }
            City tmpC = new City(3,"Tomsk");
            cityDAO.updateCity(Omsk);
            cityDAO.deleteCity(cityDAO.readById(1));
            System.out.println("-------------------------------------------------------------------------------------");
            cityList = cityDAO.readAllElements();
            for (City el : cityList) {
                    System.out.println(el);
            }
            System.out.println("-------------------------------------------------------------------------------------");
            Employee tmpE = new Employee(3,"Olga","Sokolova","woman" ,23,cityDAO.readById(2));
            System.out.println(Olga);
            employeeDAO.updateEmployee(Olga); // Illegal attempt to associate a collection with two open sessions.
            System.out.println(employeeDAO.readById(3));


            System.out.println("-------------------------------------------------------------------------------------");
            employeeDAO.deleteEmployee(employeeDAO.readById(3));
            employeeDAO.deleteEmployee(employeeDAO.readById(4));
            employeeList = employeeDAO.readAllEmployee();
            for (Employee el : employeeList) {
                System.out.println(el);
            }

              cityDAO.deleteCity(Asha);
              cityDAO.deleteCity(cityDAO.readById(1));
        System.out.println("----- Список городов после удаления города ----------------------------------------------");
        cityList = cityDAO.readAllElements();
        for (City el : cityList) {
            System.out.println(el);
        }
        System.out.println("------ Список работников после удаления города ------------------------------------------");
        employeeList = employeeDAO.readAllEmployee();
        for (Employee el : employeeList) {
            System.out.println(el);
        }


    }
}
