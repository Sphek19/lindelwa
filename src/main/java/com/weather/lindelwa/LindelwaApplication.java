package com.weather.lindelwa;

import com.weather.lindelwa.model.Day;
import com.weather.lindelwa.model.Forecastday;
import com.weather.lindelwa.model.Weather;
import com.weather.lindelwa.service.WeatherAPIService;

import java.io.IOException;
import java.util.List;

public class LindelwaApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		WeatherAPIService weatherAPIService = new WeatherAPIService();
		Weather weather = weatherAPIService.getWeatherForecast();
		List<Forecastday> forecast_7_days = weather.getForecast().getForecastday();

		for(Forecastday forecastday : forecast_7_days) {
			System.out.println(forecastday.getDate() + " : " + forecastday.getDay().getAvgtemp_c());
		}



	}

}
