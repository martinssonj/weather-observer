package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.weather.model.Weather;

public interface WeatherService {
	
	Weather getWeather(final String userId);

}
