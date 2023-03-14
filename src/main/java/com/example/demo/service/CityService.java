package com.example.demo.service;

import com.example.demo.exception.CityNotFoundException;
import com.example.demo.exception.NoDataFoundException;
import com.example.demo.model.entity.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id));
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {
        List cities = cityRepository.findAll();

        if (cities.isEmpty()) {

            throw new NoDataFoundException();
        }

        return cities;
    }
    
    @Override
    public City update(Long id, City city) {

        return cityRepository.findById(id).map(_city -> {
            _city.setName(city.getName());
            _city.setName(city.getName());
            _city.setPopulation(city.getPopulation());
            return cityRepository.save(_city);
        }).orElseThrow(() -> new NoDataFoundException());
    }

    @Override
    public void delete(Long id) {
        if(cityRepository.existsById(id)){
            cityRepository.deleteById(id);
            return;
        }
        throw new NoDataFoundException();
    }

}
