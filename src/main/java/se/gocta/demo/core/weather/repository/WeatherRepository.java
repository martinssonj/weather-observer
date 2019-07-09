package se.gocta.demo.core.weather.repository;

import se.gocta.demo.core.weather.repository.model.CurrentWeather;

import java.util.Optional;

public interface WeatherRepository {

    Optional<CurrentWeather> getCurrentWeather(final String city, final String country);
}
