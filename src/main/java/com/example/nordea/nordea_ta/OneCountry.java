package com.example.nordea.nordea_ta;

public class OneCountry {

    public OneCountry(String name, String country_code, String capital, Number population, String flag) {
        this.name = name;
        this.country_code = country_code;
        this.capital = capital;
        this.population = population;
        this.flag = flag;
        
    }
    private String name;
    private String country_code;
    private String capital;
    private Number population;
    private String flag;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public Number getPopulation() {
        return population;
    }
    public void setPopulation(Number population) {
        this.population = population;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryCode() {
        return country_code;
    }

    public void setCountryCode(String country_code) {
        this.country_code = country_code;
    }
}
