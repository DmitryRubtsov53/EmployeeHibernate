package org.example.service;

import org.example.model.Employee;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{

    @Override
    public void createEmployee(Employee employee) {
             try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
                Transaction transaction = session.beginTransaction();
                session.save(employee);
                transaction.commit();
                session.close(); //
            }
        }

    @Override
    public Employee readById(int id) {
          return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> readAllEmployee() {
            List<Employee> employeeList = (List<Employee>) HibernateSessionFactoryUtil
                    .getSessionFactory().openSession().createQuery("FROM Employee").list();
            return employeeList;
    }


    @Override

    public void updateEmployee(Employee employee) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
                Transaction transaction = session.beginTransaction();
                session.update(employee);
                transaction.commit();
                session.close(); //
            }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
                session.close(); //
        }
    }


}
