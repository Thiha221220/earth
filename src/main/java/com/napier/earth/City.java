package com.napier.earth;

public class City {
    private String Name;


    private String Country;

    private String District;
    private Integer Population;

    public String getName() {
        return Name;
    }

    public String getCountry() {

        return Country;

    }

    public String getDistrict() {
        return District;
    }

    public Integer getPopulation() {
        return Population;
    }


    public City(String name, String country, String district, Integer population) {
        Name = name;
        Country = country;
        District = district;
        Population = population;
    }

}

