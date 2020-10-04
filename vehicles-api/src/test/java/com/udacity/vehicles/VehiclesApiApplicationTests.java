package com.udacity.vehicles;

import com.udacity.vehicles.domain.car.Car;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.json.JSONObject;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehiclesApiApplicationTests {

    @LocalServerPort
    public int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAllCars() throws JSONException {
        HttpHeaders   headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject carObject = new JSONObject();
        carObject.put("id", "");
        HttpEntity<String> request = new HttpEntity<>(carObject.toString(), headers);
        Car car = this.restTemplate.postForObject("http://localhost:" + port + "/cars", request, Car.class);
        Long id = car.getId();
    }



}
