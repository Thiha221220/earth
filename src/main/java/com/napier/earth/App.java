package com.napier.earth;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    private Connection con = null;

    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 100;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");

            }


                }

            }


        }
    }
    public void disconnect()
    {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }


    // all cities in the world
    public ArrayList<city> getCityPopLs()
    {
        try
        {
            String sql = "select Name, CountryCode, District, Population from city order by Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<city> cities = new ArrayList<city>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                city ct = new city(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
                cities.add(ct);
            }
            return cities;

    public ArrayList<country> getCapitalPopls()
    {
        try
        {
            String sql = "select Name, Continent, Region, Capital, Population from country order by Population desc ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<country> capital_cities = new ArrayList<country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                country cap_c = new country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
                capital_cities.add(cap_c);
                System.out.println(capital_cities);
            }
            return capital_cities;

    public ArrayList<country> getCountryPopLs()
    {
        try
        {
            String sql = "select Name, Continent, Region, Capital, Population from country order by Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<country> countries = new ArrayList<country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                country cou = new country(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getFloat(5));
                countries.add(cou);
            }
            return countries;


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    public void displayCity(ArrayList<city> cnt)
    {
        System.out.println("All Cities in the World");
        System.out.println("City Name, Population");
        for (city c: cnt)
        {

            System.out.println(c.getName()+c.getPopulation());
        }
    }
    //all cities in the world


    // all cities in a country
    public ArrayList<city> getCityCountryPopLs()
    {
        try
        {
            String sql = "select Name, Population from city where CountryCode='KOR' order by Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<city> coucity = new ArrayList<city>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                city cct = new city(rset.getString(1),rset.getFloat(2));
                coucity.add(cct);
            }
            return coucity;


            System.out.println("Failed to get all capital city details");
            return null;
        }
    }
    public void displayCapital(ArrayList<country> capcNum)
    {
        for (country cap: capcNum)
        {
            System.out.println(cap.getCapital()+cap.getName()+cap.getPopulation());
        }
    }

    public ArrayList<city> getDistrictPopls()
    {
        try
        {
            String sql = "select Name, CountryCode, District, Population from city where district='England' order by Population desc ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<city> d_cities = new ArrayList<city>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                city dc = new city(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
                d_cities.add(dc);
            }
            return d_cities;


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city in a country");
            return null;
        }
    }
    public void displayCityCountry(ArrayList<city> ccnt)
    {
        System.out.println("All cities in a country");
        System.out.println("City Name, Population");
        for (city c: ccnt)
        {
            System.out.println(c.getName()+"  "+c.getPopulation());
        }
    }
    //all cities in a country

    //all cities in a continent
    public ArrayList<city> getCityContinentPopLs()
    {
        try
        {
            String sql = "select city.Name, city.CountryCode, city.Population from city, country where city.CountryCode = country.Code and country.Continent='Europe' order by city.Population desc ";
            ArrayList<city> cityconti = new ArrayList<city>();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                city cct = new city(rset.getString(1), rset.getString(2), rset.getFloat(3));
                cityconti.add(cct);
            }
            return cityconti;

            System.out.println("Failed to get all cities in a district details");
            return null;
        }
    }
    public void displayCity(ArrayList<city> dcNum)
    {
        for (city dc: dcNum)
        {
            System.out.println(dc.getName()+dc.getCountry()+dc.getDistrict()+dc.getPopulation());
        }
    }
    //    all the cities in a region
    public ArrayList<city> getRegionPopls()
    {
        try
        {
            String sql = "select city.Name, city.Country, city.District, city.Population from city, country where city.Country = country.Code and country.Region='Southeast Asia' order by city.Population desc ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<city> r_cities = new ArrayList<city>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                city rc = new city(
                        rset.getString(1),
                        rset.getString(2),
                        rset.getString(3),
                        rset.getFloat(4));
                r_cities.add(rc);
            }
            return r_cities;

            System.out.println("Failed to get country details");
            return null;
        }
    }
    public void displayCountry(ArrayList<country> couNum)
    {
        System.out.println("All the countries in the world organised by largest population to smallest");
        for (country c: couNum)
        {
            System.out.println("All the countries in the world organised by largest population to smallest");
            System.out.println(c.getName()+String.valueOf(c.getPopulation()));
    }
    public ArrayList<country> getCountryPopLsRegion()
    {
        try
        {
            String sql = "select Name, Region, Population from country where Region = 'Southeast Asia' order by Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<country> countries1 = new ArrayList<country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                country cou = new country(rset.getString(1),rset.getString(2),rset.getFloat(3));
                countries1.add(cou);
            }
            return countries1;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

            System.out.println("Failed to get city in a continent");
            return null;
        }
    }
    public void displayCityContinent(ArrayList<city> ccnt)
    {
        System.out.println("All cities in a continent");
        System.out.println("City Name, Country Code, Population");
        for (city c: ccnt)
        {
            System.out.println(c.getName()+c.getCountry()+c.getPopulation());
        }


            System.out.println("Failed to get all cities in a region details");
            return null;
        }
    }
    public void displayRegion(ArrayList<city> rcNum)
    {
        for (city rci: rcNum)
        {
            System.out.println(rci.getName()+rci.getDistrict()+rci.getPopulation());
        }
    }



            System.out.println("Failed to get country details");
            return null;
        }
    }
    public void displayCountryPopLSRegion(ArrayList<country> couNum)
    {

        System.out.println("All the countries in South East Asia organised by largest population to smallest");
        for (country c: couNum)
        {

            System.out.println(c.getName()+String.valueOf(c.getPopulation()));
    }

    public static void main(String[] args)
    {
        App a = new App();
        a.connect();
        ArrayList<city> cities = a.getCityPopLs();
        a.displayCity(cities);
        ArrayList<city> coucities = a.getCityCountryPopLs();
        a.displayCityCountry(coucities);
        ArrayList<city> cityconti = a.getCityContinentPopLs();
        a.displayCityContinent(cityconti);
    
        ArrayList<country> capital_cities = a.getCapitalPopls();
        a.displayCapital(capital_cities);
        ArrayList<city> d_cities = a.getDistrictPopls();
        a.displayCity(d_cities);
        ArrayList<city> r_cities = a.getRegionPopls();
        a.displayRegion(r_cities);

        ArrayList<country> countries = a.getCountryPopLs();
        a.displayCountry(countries);
        ArrayList<country> countriesRegionLS = a.getCountryPopLsRegion();
        a.displayCountryPopLSRegion(countriesRegionLS);
        a.disconnect();
    }
}

