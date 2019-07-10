package se.gocta.demo.resources.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherModel {

    private String temperature;
    private String city;
    private String country;
    private String time;
    private String periodStart;
    private String periodEnd;

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

    @JsonProperty
    public String getTime() {
        return time;
    }

    @JsonProperty
    public String getPeriodStart() {
        return periodStart;
    }

    @JsonProperty
    public String getPeriodEnd() {
        return periodEnd;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String temperature;
        private String city;
        private String country;
        private String time;
        private String periodStart;
        private String periodEnd;

        private Builder() {
        }

        public Builder temperature(final String temperature) {
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

        public Builder time(final String time) {
            this.time = time;
            return this;
        }

        public Builder periodStart(final String periodStart) {
            this.periodStart = periodStart;
            return this;
        }

        public Builder periodEnd(final String periodEnd) {
            this.periodEnd = periodEnd;
            return this;
        }

        public WeatherModel build() {
            final WeatherModel weatherModel = new WeatherModel();
            weatherModel.periodStart = this.periodStart;
            weatherModel.time = this.time;
            weatherModel.temperature = this.temperature;
            weatherModel.country = this.country;
            weatherModel.city = this.city;
            weatherModel.periodEnd = this.periodEnd;
            return weatherModel;
        }
    }
}
