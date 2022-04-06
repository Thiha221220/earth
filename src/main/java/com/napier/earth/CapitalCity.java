package com.napier.earth;

/**
 * @author Thiha Htun Htun
 * @version 4.0
 * @since 1.0
 */

public class CapitalCity {
    private String Name;

    private String Country;

    private Integer Population;

    /**
     * get capital city name
     * @return Name
     */

    public String getName() {
        return Name;
    }

    /**
     * get country
     * @return Country
     */

    public String getCountry() {
        return Country;
    }

    /**
     * get population
     * @return Population
     */

    public Integer getPopulation() {
        return Population;
    }

    /**
     *  Capital City Report Constructor
     */

    public CapitalCity(String name, String country, Integer population) {
        Name = name;
        Country = country;
        Population = population;
    }
}