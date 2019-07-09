package se.gocta.demo.resources.weather;

import se.gocta.demo.core.weather.model.Weather;
import se.gocta.demo.core.weather.service.WeatherService;
import se.gocta.demo.resources.weather.model.WeatherModel;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class WeatherResourceImpl implements WeatherResource {

    private final WeatherService weatherService;

    @Inject
    public WeatherResourceImpl(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public WeatherModel getWeather(final String userId) {

        //TODO
        final Weather weather = weatherService.getWeather("Jönköping", "Sweden").get();

        return new WeatherModel(String.format("%.2f", weather.getTemperature()), weather.getCity(), weather.getCountry());

    }

    @Override public Response addCity(final String userId, final String city, final String countryCode) {
        if (weatherService.getWeather(city, countryCode).isPresent()) {
            return Response.ok().build();
        }

        return Response.status(NOT_FOUND).build();
    }

}
