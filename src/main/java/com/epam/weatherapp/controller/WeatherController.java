package com.epam.weatherapp.controller;

import com.epam.weatherapp.model.Weather;
import com.epam.weatherapp.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.epam.weatherapp.config.AppConfig.WEATHER_API_URL;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<String> getWeatherData(
            @RequestParam(name = "zipCode", required = false) String zipCode,
            @RequestParam(name = "city", required = false) String city) {

        if ((zipCode == null || zipCode.isEmpty()) && (city == null || city.isEmpty())) {
            return ResponseEntity.badRequest().body("Please provide either zipCode or city parameter.");
        }

        String apiUrl = buildApiUrl(zipCode, city);
        Weather weatherData = weatherService.getWeatherData(apiUrl);

        return ResponseEntity.ok(weatherData.toString());
    }

    private String buildApiUrl(String zipCode, String city) {
        StringBuilder apiUrlBuilder = new StringBuilder(WEATHER_API_URL);
        if (zipCode != null && !zipCode.isEmpty()) {
            apiUrlBuilder.append("&zip=").append(zipCode);
        } else if (city != null && !city.isEmpty()) {
            apiUrlBuilder.append("&q=").append(city);
        }

        return apiUrlBuilder.toString();
    }
}
