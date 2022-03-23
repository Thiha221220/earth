package com.napier.earth;
public class country
{
    private int Code;
    private String Name;
    private String Continent;
    private String Region;
    private int Population;
    private String Capital;

    public int getCode() {
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

    public int getPopulation() {
        return Population;
    }

    public String getCapital() {
        return Capital;
    }

    public country(int code, String name, String continent, String region, int population, String capital) {
        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Population = population;
        Capital = capital;
    }
}