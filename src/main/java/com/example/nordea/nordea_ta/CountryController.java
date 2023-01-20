package com.example.nordea.nordea_ta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final RestTemplate restTemplate;

    public CountryController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    }

    @GetMapping()
    public List<CountryAll> getAllCountries() {
        String url = "https://restcountries.com/v3.1/all";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);
        JsonNode root = response.getBody();
        List<CountryAll> CountryAllList = new ArrayList<>();
        for (JsonNode country : root) {
            String countryName = country.get("name").get("common").asText();
            String country_code = country.get("cca2").asText();
            CountryAll CountryAll = new CountryAll(countryName, country_code);
            CountryAllList.add(CountryAll);
        }
        return CountryAllList;
    }
}
