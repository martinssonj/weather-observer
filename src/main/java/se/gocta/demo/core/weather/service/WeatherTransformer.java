package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.weather.repository.model.CurrentWeather;
import se.gocta.demo.core.weather.service.model.Weather;

import java.time.Instant;
import java.util.function.Function;

public class WeatherTransformer implements Function<CurrentWeather, Weather> {

    @Override
    public Weather apply(final CurrentWeather currentWeather) {
        return Weather.builder()
                .temperature(convertToFahrenheit(currentWeather.getMain().getTemp()))
                .city(currentWeather.getName())
                .cityId(currentWeather.getId())
                .country(currentWeather.getSys().getCountry())
                .dateTime(Instant.ofEpochSecond(currentWeather.getDt()))
                .build();
    }

    private double convertToFahrenheit(final Double kelvin) {
        return ((kelvin - 273) * (9D / 5D)) + 32;
    }
}
