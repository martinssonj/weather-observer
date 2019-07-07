package se.gocta.demo.core.weather.service;

import javax.inject.Inject;

import se.gocta.demo.core.weather.model.Weather;

public class WeatherServiceImpl implements WeatherService {

	
	@Inject
	public WeatherServiceImpl() {
		
	}
	
	@Override
	public Weather getWeather(String userId) {
		return new Weather(75, "San Diego", "US");

	}

}
