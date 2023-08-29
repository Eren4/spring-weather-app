package com.netchum.weatherapp.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netchum.weatherapp.entities.City;
import com.netchum.weatherapp.entities.WeatherInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();

    private List<City> cities = List.of(
            new City("Ankara", 32.866287, 39.925533),
            new City("Tokyo", 139.839478, 35.652832),
            new City("Madrid", -3.703790, 40.416775),
            new City("Seoul", 127.024612, 37.532600),
            new City("Berlin", 13.404954, 52.520008)
    );

    public WeatherInfo getWeatherInfoForCity(String cityName) {
        City myCity = null;

        for(City city: cities) {
            if(city.getName().equals(cityName)) {
                myCity = city;
                break;
            }
        }

        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + myCity.getLatitude() +
                "&longitude=" + myCity.getLongitude() + "&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";

        ResponseEntity<String> response = restTemplate.exchange(
                apiUrl, HttpMethod.GET, null, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            String jsonResponse = response.getBody();
            return parseJsonToObtainWeatherInfo(jsonResponse);
        } else {
            // Handle error or return a default WeatherData object
            return new WeatherInfo();
        }
    }

    public WeatherInfo parseJsonToObtainWeatherInfo(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode currentWeatherNode = rootNode.get("current_weather");

            String time = currentWeatherNode.get("time").asText();

            double temperature = currentWeatherNode.get("temperature").asDouble();

            double windSpeed = currentWeatherNode.get("windspeed").asDouble();

            double windDirectionDouble = currentWeatherNode.get("winddirection").asDouble();

            WeatherInfo weatherInfo = new WeatherInfo(time, temperature, windSpeed, windDirectionDouble);

            return weatherInfo;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
