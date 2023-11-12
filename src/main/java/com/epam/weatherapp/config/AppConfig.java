package com.epam.weatherapp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    public static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&APPID=88fe9edff1c38f614e49bbc96d853729";
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}