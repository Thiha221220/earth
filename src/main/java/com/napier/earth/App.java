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
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect();
        ArrayList<city> cities = a.getCityPopLs();
        a.displayCity(cities);
        ArrayList<city> coucities = a.getCityCountryPopLs();
        a.displayCityCountry(coucities);
        ArrayList<city> cityconti = a.getCityContinentPopLs();
        a.displayCityContinent(cityconti);
        // Disconnect from database
        a.disconnect();
    }
}

