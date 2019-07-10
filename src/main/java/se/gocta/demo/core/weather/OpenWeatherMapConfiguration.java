package se.gocta.demo.core.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherMapConfiguration {

    private final String baseUrl;
    private final String appId;

    public OpenWeatherMapConfiguration(@JsonProperty("baseUrl") final String baseUrl, @JsonProperty("appId") final String appId) {
        this.baseUrl = baseUrl;
        this.appId = appId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAppId() {
        return appId;
    }
}
