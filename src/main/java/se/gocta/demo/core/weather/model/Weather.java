package se.gocta.demo.core.weather.model;

public class Weather {

    private final double temperature;
    private final String city;
    private final String country;

    public Weather(final double temperature, final String city, final String country) {
        super();
        this.temperature = temperature;
        this.city = city;
        this.country = country;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}
