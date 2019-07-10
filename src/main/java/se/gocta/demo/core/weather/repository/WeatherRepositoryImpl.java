package se.gocta.demo.core.weather.repository;

import se.gocta.demo.WeatherObserverConfiguration;
import se.gocta.demo.core.weather.repository.model.CurrentWeather;

import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * Fetches information from Open Weather Map
 */
public class WeatherRepositoryImpl implements WeatherRepository {

    private final WebTarget target;
    private final String appId;

    @Inject
    public WeatherRepositoryImpl(final WeatherObserverConfiguration weatherObserverConfiguration) {
        target = ClientBuilder
                .newClient()
                .target(weatherObserverConfiguration.getOpenWeatherMapConfiguration().getBaseUrl());
        appId = weatherObserverConfiguration.getOpenWeatherMapConfiguration().getAppId();
    }

    @Override
    public Optional<CurrentWeather> getCurrentWeather(final String city, final String country) {
        final Response response = target.path("weather")
                .queryParam("q", city + "," + country)
                .queryParam("APPID", appId)
                .request().get();

        if (response.getStatus() == 200) {
            return Optional.of(response.readEntity(CurrentWeather.class));
        }
        return Optional.empty();
    }

    @Override public Optional<CurrentWeather> getCurrentWeather(final Integer cityId) {
        final Response response = target.path("weather")
                .queryParam("id", cityId)
                .queryParam("APPID", appId)
                .request().get();

        if (response.getStatus() == 200) {
            //Let Jersey unmarshall
            return Optional.of(response.readEntity(CurrentWeather.class));
        }
        return Optional.empty();
    }

}
