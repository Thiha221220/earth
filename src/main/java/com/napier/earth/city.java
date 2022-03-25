package com.napier.earth;

public class city {
    private String Name;

    private String CountryCode;

    private String Country;

    private String District;
    private Float Population;

    public String getName() {
        return Name;
    }

    public String getCountry() {

        return CountryCode;

        return Country;

    }

    public String getDistrict() {
        return District;
    }

    public Float getPopulation() {
        return Population;
    }


    public city(String name, String countrycode, String district, Float population) {
        Name = name;
        CountryCode = countrycode;
        District = district;
        Population = population;
    }

    public city(String name, Float population) {
        Name = name;
        Population = population;
    }

    public city(String name, String countryCode, Float population) {
        Name = name;
        CountryCode = countryCode;
        Population = population;
    }

    public city(String name, String country, String district, Float population) {
        Name = name;
        Country = country;
        District = district;
        Population = population;
    }

}
