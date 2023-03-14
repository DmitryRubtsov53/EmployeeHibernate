package org.example.service;

import org.example.model.City;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAOImpl implements CityDAO{
    @Override
    public void createCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
            session.close();
        }
    }

    @Override
    public City readById(Integer cityId) {
        // первоначальная редакция не позволяет использовать метод в нутри метода удаления города
        // (сессия остается открытой + сессия метода удаления --> ОШИБКА:  Illegal attempt to associate a collection with two open sessions.)
        //return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class,cityId);
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(City.class, cityId);
        }
    }

    @Override
    public List<City> readAllElements() {
        return (List<City>) HibernateSessionFactoryUtil
                .getSessionFactory().openSession().createQuery("FROM City").list();
    }

    @Override
    public void updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void deleteCity(City city) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
            session.close();
        }
    }
}
