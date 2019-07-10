package se.gocta.demo.resources.weather;

import se.gocta.demo.resources.weather.model.WeatherModel;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("weather")
@Produces("application/json")
public interface WeatherResource {

    @GET
    List<WeatherModel> getWeather(@QueryParam("userId") final String userId);

    @PUT
    Response addCity(@QueryParam("userId") String userId,
            @QueryParam("city") String city,
            @QueryParam("countryCode") String countryCode,
            @QueryParam("periodStart") String periodStart,
            @QueryParam("periodEnd") String periodEnd);
}
