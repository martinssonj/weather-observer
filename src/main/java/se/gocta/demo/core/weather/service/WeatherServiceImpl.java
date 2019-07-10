package se.gocta.demo.core.weather.service;

import se.gocta.demo.core.user.service.UserService;
import se.gocta.demo.core.user.service.model.City;
import se.gocta.demo.core.weather.repository.WeatherRepository;
import se.gocta.demo.core.weather.service.model.Weather;

import javax.inject.Inject;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    private final WeatherTransformer weatherTransformer;

    private final UserService userService;

    @Inject
    public WeatherServiceImpl(final WeatherRepository weatherRepository,
            final UserService userService) {
        this.weatherRepository = weatherRepository;
        this.userService = userService;
        this.weatherTransformer = new WeatherTransformer();
    }

    @Override
    public boolean addCity(final String userId, final Instant periodStart, final Instant periodEnd, final String city,
            final String country) {
        final Optional<Weather> weather = weatherRepository.getCurrentWeather(city, country).map(weatherTransformer);

        if (weather.isPresent()) {
            userService.save(userId, weather.get().getCityId(), periodStart, periodEnd);
            return true;
        }

        return false;
    }

    @Override
    public List<Weather> getObservations(final String userId) {
        return userService.fetch(userId).map(userData -> {
            List<Weather> list = new ArrayList<>();
            for (final Map.Entry<Integer, City> entry : userData.getCities().entrySet()) {

                final City city = entry.getValue();
                Optional<Weather> weather = weatherRepository.getCurrentWeather(city.getCityId())
                        .map(weatherTransformer);

                if (weather.isPresent()) {
                    final Weather w = weather.get();
                    if ((w.getDateTime().isAfter(city.getPeriodStart()) || w.getDateTime().equals(city.getPeriodStart()))
                            && w.getDateTime().isBefore(city.getPeriodEnd()) || w.getDateTime().equals(city.getPeriodEnd())) {
                        w.setPeriodStart(city.getPeriodStart());
                        w.setPeriodEnd(city.getPeriodEnd());
                        list.add(w);
                    }
                }

            }
            return list;
        }).orElseGet(Collections::emptyList);
    }

}
