package com.example.demo;

import com.example.demo.model.entity.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    private City city;

    @BeforeEach
    public void setUp(){
        city = City.builder().id(new Long(1)).name("Sylhet").population(12000).build();
    }
    @Test
    public void givenCityObject_whenSaveCity_thenReturnCityObject(){
        // given - precondition or setup

        when(cityRepository.save(city)).thenReturn(city);

        // when -  action or the behaviour that we are going test
        City _city = cityService.save(city);
        // then - verify the output
        assertThat (city).isNotNull();

    }
    @Test
    public void customer_exists_in_db_success() {
        City _city = City.builder().id(new Long(2)).name("Rangpur").population(12000).build();

        List<City> list = new ArrayList<>();
        list.add(city);

        // providing knowledge
        when(cityRepository.findAll()).thenReturn(list);

        List<City> fetchedCities = cityService.findAll();
        assertThat(fetchedCities.size()).isGreaterThan(0);
    }

}
