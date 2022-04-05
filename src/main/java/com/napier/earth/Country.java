package com.napier.earth;
/**
 * @author Hein Htet Zaw
 * @version 4.0
 * @since 1.0
 */
public class Country
{
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Integer Population;
    private String Capital;

    /**
     * get country code
     * @return Code
     */
    public String getCode() {
        return Code;
    }
    /**
     *  get country name
     * @return Name
     */
    public String getName() {
        return Name;
    }
    /**
     *  get continent name
     * @return Continent
     */
    public String getContinent() {
        return Continent;
    }
    /**
     *  get region name
     * @return Region
     */
    public String getRegion() {
        return Region;
    }
    /**
     *  get population
     * @return Population
     */
    public Integer getPopulation() {
        return Population;
    }
    /**
     *  get Capital City
     * @return Capital
     */
    public String getCapital() {
        return Capital;
    }

    /**
     *  Country Constructor
     */
    public Country(String code, String name, String continent, String region, Integer population, String capital) {

        Code = code;
        Name = name;
        Continent = continent;
        Region = region;
        Capital = capital;
        Population = population;
    }

    /**
     *  World Population Constructor
     */

    public Country(Integer population) {
        Population = population;
    }

    /**
     *  Continent Constructor
     */

    public Country(String continent, Integer population) {
        Continent = continent;
        Population = population;
    }
}