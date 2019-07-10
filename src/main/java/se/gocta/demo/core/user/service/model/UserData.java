package se.gocta.demo.core.user.service.model;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private Map<Integer, City> cities = new HashMap<>();

    public Map<Integer, City> getCities() {
        return cities;
    }

    public void setCities(final Map<Integer, City> cities) {
        this.cities = cities;
    }

}
