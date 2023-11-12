package com.epam.weatherapp.service;

import com.epam.weatherapp.model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class WeatherServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getWeatherData_Successful() {
        // Mocking the external API response
        String mockApiResponse = "{ \"temperature\": 25.5, \"humidity\": 70, \"description\": \"Partly cloudy\" }";
        ResponseEntity<String> mockResponseEntity = new ResponseEntity<>(mockApiResponse, HttpStatus.OK);
        when(restTemplate.getForEntity(any(String.class), any(Class.class))).thenReturn(mockResponseEntity);

        // Performing the test
        Weather weather = weatherService.getWeatherData("https://api.example.com/weather");

        // Assertions
        assertEquals(25.5, weather.getTemperature());
        assertEquals(70, weather.getHumidity());
        assertEquals("Partly cloudy", weather.getDescription());
    }

    @Test
    void getWeatherData_ApiError() {
        // Mocking the external API response with an error status
        ResponseEntity<String> mockResponseEntity = new ResponseEntity<>("Error message", HttpStatus.INTERNAL_SERVER_ERROR);
        when(restTemplate.getForEntity(any(String.class), any(Class.class))).thenReturn(mockResponseEntity);

        // Performing the test
        Weather weather = weatherService.getWeatherData("https://api.example.com/weather");

        // Assertions
        // Ensure that the Weather object is null in case of API error
        assertEquals(null, weather);
    }
}
