package com.example.demo.service;

import com.example.demo.model.entity.City;

import java.util.List;

public interface ICityService {
    City findById(Long id);
    City save(City city);
    List<City> findAll();
    City update(Long id, City city);
    void delete(Long id);
}
