package com.napier.earth;

public class city {
    private  int ID;
    private String Name;
    private String CountryCode;
    private String District;
    private Float Population;

    public int getID(){return ID; }

    public String getName() {return Name;}

    public String getCountryCode() {
        return CountryCode;
    }

    public String getDistrict() {
        return District;
    }

    public Float getPopulation() {
        return Population;
    }

    public city(int id, String name, String countrycode, String district, Float population) {
        ID = id;
        Name = name;
        CountryCode = countrycode;
        District = district;
        Population = population;
    }
}
