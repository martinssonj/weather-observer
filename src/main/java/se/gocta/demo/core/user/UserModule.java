package se.gocta.demo.core.user;

import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;
import se.gocta.demo.WeatherObserverConfiguration;
import se.gocta.demo.core.user.service.UserService;
import se.gocta.demo.core.user.service.UserServiceImpl;

public class UserModule extends DropwizardAwareModule<WeatherObserverConfiguration> {

    private UserModule() {

    }

    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class).asEagerSingleton();
    }

    public static UserModule userModule() {
        return new UserModule();
    }

}
