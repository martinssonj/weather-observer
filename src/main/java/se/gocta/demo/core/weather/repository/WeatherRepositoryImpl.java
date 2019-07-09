package se.gocta.demo.core.weather.repository;

import se.gocta.demo.core.weather.repository.model.CurrentWeather;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.Optional;

public class WeatherRepositoryImpl implements WeatherRepository {

    private final Client client;
    private static final String APPID = "e910f1bca295fe5626326d19dca04c77";

    public WeatherRepositoryImpl() {
        client = ClientBuilder.newClient();
    }

    @Override
    public Optional<CurrentWeather> getCurrentWeather(final String city, final String country) {
        final Response response = client.target("http://api.openweathermap.org/data/2.5/weather")
                .queryParam("q", city + "," + country).queryParam("APPID", APPID).request().get();

        if (response.getStatus() == 200) {
            return Optional.of(response.readEntity(CurrentWeather.class));
        }
        return Optional.empty();
    }

}
