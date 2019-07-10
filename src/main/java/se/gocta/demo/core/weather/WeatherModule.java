package se.gocta.demo.core.weather;

import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import se.gocta.demo.WeatherObserverConfiguration;
import se.gocta.demo.core.weather.repository.WeatherRepository;
import se.gocta.demo.core.weather.repository.WeatherRepositoryImpl;
import se.gocta.demo.core.weather.service.WeatherService;
import se.gocta.demo.core.weather.service.WeatherServiceImpl;

/*
 * Guice Module for weather
 */
public class WeatherModule extends DropwizardAwareModule<WeatherObserverConfiguration> {

    private WeatherModule() {

    }

    @Override
    protected void configure() {
        bind(WeatherService.class).to(WeatherServiceImpl.class).asEagerSingleton();
        bind(WeatherRepository.class).to(WeatherRepositoryImpl.class).asEagerSingleton();
    }

    public static WeatherModule weatherModule() {
        return new WeatherModule();
    }

}
