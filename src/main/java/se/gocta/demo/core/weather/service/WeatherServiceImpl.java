package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.weather.model.Weather;
import se.gocta.demo.core.weather.repository.WeatherRepository;

import javax.inject.Inject;
import java.util.Optional;

public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    private final WeatherTransformer weatherTransformer;

    @Inject
    public WeatherServiceImpl(final WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        this.weatherTransformer = new WeatherTransformer();
    }

    @Override
    public Optional<Weather> getWeather(final String city, final String country) {
        return weatherRepository.getCurrentWeather(city, country)
                .map(weatherTransformer);

    }

}
