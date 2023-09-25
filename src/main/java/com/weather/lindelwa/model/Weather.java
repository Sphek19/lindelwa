package com.weather.lindelwa.model;

import lombok.Data;

@Data
public class Weather {
    private Location location;
    private Current current;
    private Forecast forecast;

}
