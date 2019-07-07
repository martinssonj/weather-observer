package se.gocta.demo.resources.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherModel {
	
	double temperature;
	String city;
	String country;
	
	public WeatherModel() {
		//Used by Jackson
	}

	
	public WeatherModel(double temperature, String city, String country) {
		super();
		this.temperature = temperature;
		this.city = city;
		this.country = country;
	}

	@JsonProperty
	public double getTemperature() {
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
