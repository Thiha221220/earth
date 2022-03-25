package com.napier.earth;
public class country
{
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Float Population;
    private String Capital;

    public country(String name, String region, float population) {
        Name = name;
        Region = region;
        Population = population;
    }

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

    public Float getPopulation() {
        return Population;
    }

    public String getCapital() {
        return Capital;
    }

    public country(String name, String continent, String region, String capital, Float population) {

        Name = name;
        Continent = continent;
        Region = region;
        Capital = capital;
        Population = population;
    }
}