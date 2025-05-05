package com.joaopedrofariaferreira.weatherapi.weather_api;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/weather")
public class weatherController {

    private final RestTemplate restTemplate;

    @Value("${weather.api.base-url}")
    private String baseUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    @Autowired
    public weatherController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping
    public ResponseEntity<String> getWeather(@RequestParam String location) {
        String url = String.format("%s/%s?key=%s", baseUrl, location, apiKey);
        //http://localhost:8080/weather?location=london
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/datetime")
    public ResponseEntity<String> getWeatherWithDateTime(@RequestParam String location,@RequestParam String date1, @RequestParam String date2){
        String url = String.format("%s/%s/%s/%s?key=%s", baseUrl, location, date1, date2, apiKey);
        //http://localhost:8080/weather?location=london&date1=2025-05-01&date2=2025-05-02
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }


}
