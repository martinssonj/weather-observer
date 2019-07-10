package se.gocta.demo.resources.weather;

import se.gocta.demo.core.weather.service.WeatherService;
import se.gocta.demo.resources.weather.model.WeatherModel;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

/*
 * API for weather observer
 */
public class WeatherResourceImpl implements WeatherResource {

    private static final String AMERICA_LOS_ANGELES = "America/Los_Angeles";
    private final WeatherService weatherService;
    private final WeatherModelTransformer weatherModelTransformer = new WeatherModelTransformer();

    @Inject
    public WeatherResourceImpl(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override
    public List<WeatherModel> getWeather(final String userId) {

        return weatherService.getObservations(userId).stream()
                .map(weatherModelTransformer)
                .collect(Collectors.toList());
    }

    @Override
    public Response addCity(final String userId, final String city, final String countryCode, final String periodStart,
            final String periodEnd) {

        //Convert time from PST to UTC
        final Instant start = LocalDateTime.parse(periodStart).atZone(ZoneId.of(AMERICA_LOS_ANGELES)).toInstant();
        final Instant end = LocalDateTime.parse(periodEnd).atZone(ZoneId.of(AMERICA_LOS_ANGELES)).toInstant();

        if (weatherService.addCity(userId, start, end, city, countryCode)) {
            return Response.status(CREATED).build();
        }

        return Response.status(NOT_FOUND).build();
    }

}
