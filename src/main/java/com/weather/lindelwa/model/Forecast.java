package com.weather.lindelwa.model;

import lombok.Data;

import java.util.List;

@Data
public class Forecast {

    private List<Forecastday> forecastday;

}
