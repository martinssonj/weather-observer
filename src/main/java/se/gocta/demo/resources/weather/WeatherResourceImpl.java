package se.gocta.demo.resources.weather;

import javax.inject.Inject;

import se.gocta.demo.core.weather.model.Weather;
import se.gocta.demo.core.weather.service.WeatherService;
import se.gocta.demo.resources.weather.model.WeatherModel;

public class WeatherResourceImpl implements WeatherResource {

	final WeatherService weatherService;
	
	@Inject
	public WeatherResourceImpl(final WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@Override
	public WeatherModel getWeather(final String userId) {
		final Weather weather = weatherService.getWeather(userId);
		
		return new WeatherModel(weather.getTemperature(), weather.getCity(), weather.getCountry());
		
	}

}
