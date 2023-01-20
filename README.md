Nordea Technical Assessment
=======================

This application is a simple RESTful web service that allows the user to retrieve information about countries from the [REST Countries API](https://restcountries.com/).

Getting Started
---------------

To run this API, you will need to have Java and Spring Boot installed on your machine.

You can download the latest version of Java from the [official website](https://www.java.com/en/download/).

You can download the latest version of Spring Boot from the [official website](https://spring.io/projects/spring-boot).

### Installing

1.  Clone the repository to your local machine
2.  Navigate to the project directory
3.  Run the following command to build and run the application:

`mvnw spring-boot:run`

This will start the API on `http://localhost:8080/`


Endpoints
---------

### Retrieve all countries

This endpoint retrieves information about all countries and returns it in a JSON format.

#### Request

`GET http://localhost:8080/countries/`

#### Response

`{
    "countries": [
      {
        "name": "Afghanistan",
        "country_code": "AF"
      },
      {
        "name": "Åland Islands",
        "country_code": "AX"
      },
      ...]
}`

### Retrieve information about a specific country

This endpoint retrieves information about a specific country and returns it in a JSON format.

#### Request

`GET http://localhost:8080/countries/{name}`

Where `{name}` is the name of the country you want to retrieve information about.

#### Response

`{
    "name": "United Kingdom",
    "country_code": "GB",
    "capital": "London",
    "population": 66488991,
    "flag": "https://restcountries.com/v3.1/flags/gb.png"
}`
