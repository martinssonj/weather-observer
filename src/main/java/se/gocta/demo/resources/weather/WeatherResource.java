package se.gocta.demo.resources.weather;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import se.gocta.demo.resources.weather.model.WeatherModel;

@Path("weather")
@Produces("application/json")
public interface WeatherResource {

	@GET
	WeatherModel getWeather(@QueryParam("userId")final String userId);
	
}
