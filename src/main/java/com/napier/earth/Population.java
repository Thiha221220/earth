package com.napier.earth;
/**
 * @author Yoon Shwe Lwin
 * @version 4.0
 * @since 1.0
 */
public class Population {
    private String Name;
    private long Total;
    private long Living;
    private long Notliving;

    /**
     * get Continent/Region/Country Name
     * @return  Name
     */
    public String getName() { return Name; }

    /**
     * get Total Population
     * @return Total
     */
    public long getTotal() {
        return Total;
    }

    /**
     * get Populated people living in cities
     * @return living
     */
    public long getLiving() {
        return Living;
    }

    /**
     * get Populated people not living in cities
     * @return Notliving;
     */
    public long getNotliving() {
        return Notliving;
    }

    /**
     *  Population Constructor
     */
    public Population(String name, long total, long living, long notliving) {
        Name = name;
        Total = total;
        Living = living;
        Notliving = notliving;
    }

}
