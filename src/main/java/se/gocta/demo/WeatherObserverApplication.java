package se.gocta.demo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import se.gocta.demo.core.user.UserModule;
import se.gocta.demo.core.weather.WeatherModule;

public class WeatherObserverApplication extends Application<WeatherObserverConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WeatherObserverApplication().run(args);
    }

    @Override
    public String getName() {
        return "weather-observer";
    }

    @Override
    public void initialize(final Bootstrap<WeatherObserverConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.builder()
                .modules(WeatherModule.weatherModule(), UserModule.userModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .build());
    }

    @Override
    public void run(final WeatherObserverConfiguration configuration,
            final Environment environment) {
        // TODO: implement application

    }

}
