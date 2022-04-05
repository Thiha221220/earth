package com.napier.earth;

/**
 * @author Yoon Shwe Lwin
 * @version 4.0
 * @since 1.0
 */

public class City {

    private String Name;

    private String Country;

    private String District;

    private Integer Population;

    /**
     * get city name
     * @return Name
     */

    public String getName() {
        return Name;
    }

    /**
     * get country name
     * @return Country
     */

    public String getCountry() {
        return Country;
    }

    /**
     * get district name
     * @return district
     */

    public String getDistrict() {
        return District;
    }

    /**
     * get population
     * @return Population
     */

    public Integer getPopulation() {
        return Population;
    }

    /**
     *  City Report Constructor
     */

    public City(String name, String country, String district, Integer population) {
        Name = name;
        Country = country;
        District = district;
        Population = population;
    }

}

