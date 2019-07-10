package se.gocta.demo;

import io.dropwizard.Configuration;
import se.gocta.demo.core.weather.OpenWeatherMapConfiguration;

public class WeatherObserverConfiguration extends Configuration {

    private OpenWeatherMapConfiguration openWeatherMapConfiguration;

    public OpenWeatherMapConfiguration getOpenWeatherMapConfiguration() {
        return openWeatherMapConfiguration;
    }

    public void setOpenWeatherMapConfiguration(final OpenWeatherMapConfiguration openWeatherMapConfiguration) {
        this.openWeatherMapConfiguration = openWeatherMapConfiguration;
    }
}
