package com.example.nordea.nordea_ta;

public class CountryAll {

    public CountryAll(String name, String country_code) {
        this.name = name;
        this.country_code = country_code;
    }
    private String name;
    private String country_code;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }
}
