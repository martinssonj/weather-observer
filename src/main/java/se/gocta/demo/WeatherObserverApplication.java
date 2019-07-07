package se.gocta.demo;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.GuiceyOptions;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.web.WebFilterInstaller;
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
    			.modules(WeatherModule.weatherModule())
    			.enableAutoConfig(getClass().getPackage().getName())
    			.build());
    	
    	System.out.println("här");
    }

    @Override
    public void run(final WeatherObserverConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	
    }

}
