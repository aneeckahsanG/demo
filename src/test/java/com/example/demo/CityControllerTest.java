package com.example.demo;

import com.example.demo.config.AuthEntryPointJwt;
import com.example.demo.config.JwtUtils;
import com.example.demo.controller.CityController;
import com.example.demo.model.entity.City;
import com.example.demo.model.response.SuccessDTO;
import com.example.demo.service.CityService;
import com.example.demo.service.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest({CityController.class})
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CityService cityService;

//    @MockBean
//    UserDetailsServiceImpl userDetailsService;

//    @MockBean
//    private AuthEntryPointJwt unauthorizedHandler;
//    @MockBean
//    private JwtUtils jwtUtils;

    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    public void save_city_test() throws Exception {

//        City city = new City((long) 1, "Rajshahi", 80000);
        City city = City.builder().id(new Long(1)).name("Rajshahi").population(20000).build();


        when(cityService.save(any(City.class))).thenReturn(city);

        SuccessDTO<Object> responseBody = new SuccessDTO<>(city);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/city")
                        .content(asJsonString(city))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().is(200))
        .andExpect(content().json(asJsonString(responseEntity)));
//        .andExpect(content().json("{\"response\": {\"body\": {\"id\": 1, \"name\": \"Rajshahi\", \"population\": 80000},\"length\": 1}}"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
