package se.gocta.demo.core.user.service;

import se.gocta.demo.core.user.service.model.UserData;

import java.time.Instant;
import java.util.Optional;

public interface UserService {

    void save(String userId, Integer cityId, Instant periodStart, Instant periodEnd);

    Optional<UserData> fetch(String userId);

}
