package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.weather.model.Weather;

import java.util.Optional;

public interface WeatherService {

    Optional<Weather> getWeather(final String city, String country);

}
