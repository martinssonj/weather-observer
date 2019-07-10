package se.gocta.demo.core.user.service;

import se.gocta.demo.core.user.service.model.City;
import se.gocta.demo.core.user.service.model.UserData;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final Map<String, UserData> database = new HashMap<>();

    @Override
    public void save(final String userId, final Integer cityId, final Instant periodStart, final Instant periodEnd) {
        final UserData userData = database.getOrDefault(userId, new UserData());
        final Map<Integer, City> cities = userData.getCities();
        cities.put(cityId, new City(cityId, periodStart, periodEnd));
        userData.setCities(cities);
        userData.setUserId(userId);

        database.put(userId, userData);
    }

    @Override
    public Optional<UserData> fetch(final String userId) {
        if (database.containsKey(userId)) {
            return Optional.of(database.get(userId));
        }

        return Optional.empty();
    }
}
