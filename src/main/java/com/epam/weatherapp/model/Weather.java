package com.epam.weatherapp.model;

import lombok.Data;

@Data
public class Weather {
    private double temperature;
    private int humidity;
    private String description;

}
