package com.epam.weatherapp.service;

// src/main/java/com.example.weather.service.WeatherService.java

import com.epam.weatherapp.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Weather getWeatherData(String url) {

        return restTemplate.getForObject(url, Weather.class);
    }
}
