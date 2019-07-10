package se.gocta.demo.core.user.service.model;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private Map<Integer, City> cities = new HashMap<>();

    private String userId;

    public Map<Integer, City> getCities() {
        return cities;
    }

    public String getUserId() {
        return userId;
    }

    public void setCities(final Map<Integer, City> cities) {
        this.cities = cities;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
