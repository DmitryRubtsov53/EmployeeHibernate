package org.example.service;

import org.example.model.City;

import java.util.List;

public interface CityDAO {
    void createCity(City city);
    City readById(Integer id);
    List<City> readAllElements();
    void updateCity(City city);
    void deleteCity(City city);

}