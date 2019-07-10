package se.gocta.demo.core.weather.service.model;

import java.time.Instant;

public class Weather {

    private double temperature;
    private String city;
    private String country;
    private Integer cityId;
    private Instant dateTime;
    private Instant periodStart;
    private Instant periodEnd;

    public double getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Integer getCityId() {
        return cityId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Instant getDateTime() {
        return dateTime;
    }

    public void setPeriodStart(final Instant periodStart) {
        this.periodStart = periodStart;
    }

    public Instant getPeriodStart() {
        return periodStart;
    }

    public void setPeriodEnd(final Instant periodEnd) {
        this.periodEnd = periodEnd;
    }

    public Instant getPeriodEnd() {
        return periodEnd;
    }

    public static final class Builder {

        private double temperature;
        private String city;
        private String country;
        private Integer cityId;
        private Instant dateTime;

        private Builder() {
        }

        public Builder temperature(final double temperature) {
            this.temperature = temperature;
            return this;
        }

        public Builder city(final String city) {
            this.city = city;
            return this;
        }

        public Builder country(final String country) {
            this.country = country;
            return this;
        }

        public Builder cityId(final Integer cityId) {
            this.cityId = cityId;
            return this;
        }

        public Builder dateTime(final Instant dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Weather build() {
            final Weather weather = new Weather();
            weather.dateTime = this.dateTime;
            weather.country = this.country;
            weather.city = this.city;
            weather.cityId = this.cityId;
            weather.temperature = this.temperature;
            return weather;
        }
    }
}
