package com.napier.earth;
public class Country
{
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Integer Population;
    private String Capital;




    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }

    public String getContinent() {
        return Continent;
    }

    public String getRegion() {
        return Region;
    }

    public Integer getPopulation() {
        return Population;
    }

    public String getCapital() {
        return Capital;
    }

    public Country(String code, String name, String continent, String region, Integer population, String capital) {

        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Capital = capital;
        Population = population;
    }

    public Country(Integer population) {
        Population = population;
    }
}