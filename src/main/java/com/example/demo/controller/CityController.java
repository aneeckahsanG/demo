package com.example.demo.controller;

import com.example.demo.model.entity.City;
import com.example.demo.service.ICityService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/city")
@Api(description = "City management API")
public class CityController {
    @Autowired
    private ICityService cityService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public City findById(@PathVariable Long id) {
        return cityService.findById(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public City save(@RequestBody City city) {
        return cityService.save(city);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<City> findAll() {
        return cityService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public City update(@PathVariable Long id, @RequestBody City city) {
        return cityService.update(id, city);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
        return;
    }

}
