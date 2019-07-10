package se.gocta.demo.core.weather.service;

import org.junit.jupiter.api.Test;
import se.gocta.demo.core.weather.repository.model.CurrentWeather;
import se.gocta.demo.core.weather.repository.model.Main;
import se.gocta.demo.core.weather.repository.model.Sys;
import se.gocta.demo.core.weather.service.model.Weather;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherTransformerTest {

    private final WeatherTransformer sut = new WeatherTransformer();

    @Test
    void apply() {
        final Sys sys = new Sys();
        sys.setCountry("US");
        final Main main = new Main();
        main.setTemp(new Double("295"));

        final CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setName("San Diego");
        currentWeather.setSys(sys);
        currentWeather.setMain(main);
        currentWeather.setDt(1562726865);

        final Weather result = sut.apply(currentWeather);

        assertThat(result.getCity()).isEqualTo("San Diego");
        assertThat(result.getCountry()).isEqualTo("US");
        assertThat(result.getTemperature()).isEqualTo(71.6D);
        assertThat(result.getDateTime()).isEqualTo(Instant.ofEpochSecond(1562726865));

    }
}