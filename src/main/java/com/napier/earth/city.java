package com.napier.earth;

public class city {
    private String Name;
    private String Country;
    private String District;
    private Float Population;

    public String getName() {
        return Name;
    }

    public String getCountry() {
        return Country;
    }

    public String getDistrict() {
        return District;
    }

    public Float getPopulation() {
        return Population;
    }

    public city(String name, String country, String district, Float population) {
        Name = name;
        Country = country;
        District = district;
        Population = population;
    }
}
