package com.napier.earth;

public class CapitalCity {
    private String Name;

    private String Country;

    private Integer Population;

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public Integer getPopulation() {
        return Population;
    }

    public CapitalCity(String name, String country, Integer population) {
        Name = name;
        Country = country;
        Population = population;
    }
}
