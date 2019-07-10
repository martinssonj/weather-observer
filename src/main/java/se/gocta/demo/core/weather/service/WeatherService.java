package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.weather.service.model.Weather;

import java.time.Instant;
import java.util.List;

public interface WeatherService {

    boolean addCity(final String userId, final Instant periodStart, final Instant periodEnd, final String city,
            String country);

    List<Weather> getObservations(final String userId);
}
