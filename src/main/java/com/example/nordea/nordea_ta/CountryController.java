package com.example.nordea.nordea_ta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/countries/")
public class CountryController {

    private String api = "https://restcountries.com/v3.1";
    private final RestTemplate restTemplate;

    public CountryController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @GetMapping()
    public Map<String, List<CountryAll>> getAllCountries() {
        String url = api + "/all";
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
        Map<String, List<CountryAll>> countries = new HashMap<>();
        countries.put("countries", CountryAllList);
        return countries;
    }
    
    @GetMapping("/{name}")
    public ResponseEntity<OneCountry> getCountryByName(@PathVariable String name) {
        String url = api + "/name/" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            JsonNode country = response.getBody().get(0);
            String commonName = country.get("name").get("common").asText();
            String cca2 = country.get("cca2").asText();
            String capital = country.get("capital").get(0).asText();
            Number population = country.get("population").asInt();
            String flag = country.get("flags").get("png").asText();
            OneCountry oneCountry = new OneCountry(commonName, cca2, capital, population, flag);
            return new ResponseEntity<>(oneCountry, HttpStatus.OK);
        } else {
            //redirect to error page
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
