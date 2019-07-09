package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.weather.model.Weather;
import se.gocta.demo.core.weather.repository.model.CurrentWeather;

import java.util.function.Function;

public class WeatherTransformer implements Function<CurrentWeather, Weather> {

    @Override public Weather apply(final CurrentWeather currentWeather) {
        return new Weather(((currentWeather.getMain().getTemp() - 273) * (9D / 5D)) + 32,
                currentWeather.getName(),
                currentWeather.getSys().getCountry());
    }
}
