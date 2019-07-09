package se.gocta.demo.resources.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherModel {

    private String temperature;
    private String city;
    private String country;

    public WeatherModel() {
        //Used by Jackson
    }

    public WeatherModel(final String temperature, final String city, final String country) {
        super();
        this.temperature = temperature;
        this.city = city;
        this.country = country;
    }

    @JsonProperty
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty
    public String getCity() {
        return city;
    }

    @JsonProperty
    public String getCountry() {
        return country;
    }

}
