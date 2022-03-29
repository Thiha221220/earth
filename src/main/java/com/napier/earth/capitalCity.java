package com.napier.earth;

public class capitalCity {
    private String Name;

    private String Country;

    private Float Population;

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public Float getPopulation() {
        return Population;
    }

    public capitalCity(String name, String country, Float population) {
        Name = name;
        Country = country;
        Population = population;
    }
}
