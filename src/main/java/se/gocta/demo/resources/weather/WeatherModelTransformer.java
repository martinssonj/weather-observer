package se.gocta.demo.resources.weather;

import se.gocta.demo.core.weather.service.model.Weather;
import se.gocta.demo.resources.weather.model.WeatherModel;

import java.time.ZoneId;
import java.util.function.Function;

/*
 * Transforms data from domain to json model
 */
public class WeatherModelTransformer implements Function<Weather, WeatherModel> {

    private static final String AMERICA_LOS_ANGELES = "America/Los_Angeles";

    @Override public WeatherModel apply(final Weather weather) {
        return WeatherModel.builder()
                .temperature(String.format("%.2f", weather.getTemperature())) //2 decimal temperature
                .city(weather.getCity())
                .country(weather.getCountry())
                .time(weather.getDateTime()
                        .atZone(ZoneId.of("UTC"))
                        .withZoneSameInstant(ZoneId.of(AMERICA_LOS_ANGELES))//Convert back to PST
                        .toLocalDateTime().toString())
                .periodEnd(weather.getPeriodEnd()
                        .atZone(ZoneId.of("UTC"))
                        .withZoneSameInstant(ZoneId.of(AMERICA_LOS_ANGELES))
                        .toLocalDateTime().toString())
                .periodStart(weather.getPeriodStart().atZone(ZoneId.of("UTC"))
                        .withZoneSameInstant(ZoneId.of(AMERICA_LOS_ANGELES))
                        .toLocalDateTime().toString())
                .build();
    }
}
