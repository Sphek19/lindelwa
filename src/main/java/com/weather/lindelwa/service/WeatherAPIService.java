package com.weather.lindelwa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.weather.lindelwa.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.weather.lindelwa.constants.WeatherConstants.*;

public class WeatherAPIService {

    HttpClient httpClient = HttpClient.newHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.registerModule(new JavaTimeModule());
    }


    public Weather getWeatherForADay(String city, String aqi) throws IOException, InterruptedException {
        String endpoint = BASE_URL + API_KEY + CITY_ATTR + city + AQI + aqi;
        HttpRequest getRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(endpoint))
                .build();

        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Weather.class);
    }

    public Weather getWeatherForecast() throws IOException, InterruptedException {
//        String endpoint = BASE_URL + API_KEY + CITY_ATTR + city + AQI + aqi;
        HttpRequest getRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("http://api.weatherapi.com/v1/forecast.json?key=d523b2db297e4a71a08193435232109&q=Durban&days=7&aqi=no&alerts=no"))
                .build();

        HttpResponse<String> response = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), Weather.class);
    }

}
