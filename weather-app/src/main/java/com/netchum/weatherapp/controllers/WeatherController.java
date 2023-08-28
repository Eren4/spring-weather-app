package com.netchum.weatherapp.controllers;

import com.netchum.weatherapp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return "weather";
    }

    @PostMapping("/")
    public String returnToHomePage() {
        return "weather";
    }

    @PostMapping("/get-weather")
    public String getWeatherInfo(@RequestParam("city") String city, Model model) {
        String modifiedCity = city.substring(0, 1).toUpperCase() + city.substring(1, city.length());

        String temperature = weatherService.getTemperatureForCity(modifiedCity);
        temperature += " °C";

        model.addAttribute("cityName", modifiedCity);
        model.addAttribute("temperature", temperature);

        return "weather-info";
    }
}
