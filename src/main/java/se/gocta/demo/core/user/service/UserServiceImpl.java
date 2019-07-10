package se.gocta.demo.core.user.service;

import se.gocta.demo.core.user.service.model.City;
import se.gocta.demo.core.user.service.model.UserData;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * When a real database is connected the database field should be a repository instead
 */
public class UserServiceImpl implements UserService {

    //Mock database
    private final Map<String, UserData> database = new HashMap<>();

    // Save or update userdata with city and period
    @Override
    public void save(final String userId, final Integer cityId, final Instant periodStart, final Instant periodEnd) {
        final UserData userData = database.getOrDefault(userId, new UserData());
        final Map<Integer, City> cities = userData.getCities();
        cities.put(cityId, new City(cityId, periodStart, periodEnd));
        userData.setCities(cities);

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
