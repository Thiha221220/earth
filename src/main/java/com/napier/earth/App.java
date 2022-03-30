package com.napier.earth;

/**
 * @author Hein Htet Zaw, Tsawm Nu Ra, Yoon Shwe Lwin, Thiha Htun Htun
 * @version 3.0
 * @since 1.0
 */

import java.sql.*;
import java.util.ArrayList;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

public class App
{

    private Connection con = null;
    /**
     * sql connect function with world database
     */
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

    /**
     * sql disconnect function
     */

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

    /**
     *  all the cities in the world organized by largest population to smallest
     * @return cities
     */

    public ArrayList<city> getCityPopLs() {
        try {
            //  sql query based on issue
            String sql = "select city.Name, country.Name, city.District, city.Population from country,city where country.Code = city.CountryCode order by city.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store cities
            ArrayList<city> cities = new ArrayList<city>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                city ct = new city(rset.getString(1), rset.getString(2), rset.getString(3), rset.getFloat(4));
                cities.add(ct);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     *  all the cities in the country organized by largest population to smallest
     * @return coucity
     */

    public ArrayList<city> getCityCountryPopLs() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city,country where city.CountryCode='KOR' and city.CountryCode = country.Code order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store city
        ArrayList<city> coucity = new ArrayList<city>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            city cct = new city(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            coucity.add(cct);
        }
        return coucity;
    }

    /**
     *  all the cities in the continent organized by largest population to smallest
     * @return cityconti
     */

    public ArrayList<city> getCityContinentPopLs() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Continent='Europe' order by city.Population desc ";
        // create array to store city
        ArrayList<city> cityconti = new ArrayList<city>();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            city cct = new city(rset.getString(1),rset.getString(2),rset.getString(3),rset.getFloat(4));
            cityconti.add(cct);
        }
        return cityconti;
    }
    /**
     *  all the cities in the district organized by largest population to smallest
     * @return d_cities
     */

    public ArrayList<city> getDistrictPopls()
    {
        try
        {
            //  sql query based on issue
            String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.district='England' and city.CountryCode = country.Code order by city.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store city
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

    /**
     *  all the cities in a region organized by largest population to smallest
     * @return r_cities
     */

    public ArrayList<city> getRegionPopls() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Region='Southeast Asia' order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store cities
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
    }
    /**
     *  The top N populated cities in a country where N is provided by the user.
     * @return TNPop_cities
     */

    public ArrayList<city> getTopNPopCit() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Name = 'Myanmar' order by city.Population desc LIMIT 10";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store top 10 populated cities
        ArrayList<city> TNPop_cities = new ArrayList<city>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            city Tn_C = new city(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getFloat(4));
            TNPop_cities.add(Tn_C);
        }
        return TNPop_cities;
    }

    /**
     *  all the country in a region organized by largest population to smallest
     * @return countries1
     */

    public ArrayList<country> getCountryPopLsRegion()
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where Region = 'Southeast Asia' and country.Capital = city.ID order by Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<country> countries1 = new ArrayList<country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                country cou = new country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5), rset.getString(6));
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
    /**
     *  all the countries in a Continent organized by largest population to smallest
     * @return couCon
     */

    public ArrayList<country> getCouCon()
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where Continent = 'Europe' and country.Capital = city.ID order by country.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<country> couCon = new ArrayList<country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                country couCons = new country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5), rset.getString(6));
                couCon.add(couCons);
            }
            return couCon;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

            System.out.println("Failed to get all the countries in a continent");
            return null;
        }
    }

    /**
     *  all the countries in the world organized by largest population to smallest
     * @return countries
     */

    public ArrayList<country> getCountryPopLs()
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where country.Capital = city.ID order by country.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<country> countries = new ArrayList<country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                country cou = new country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getFloat(5), rset.getString(6));
                countries.add(cou);
            }
            return countries;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    /**
     *  all the capital cities in the world organized by largest population to smallest
     * @return capital_cities
     */

    public ArrayList<capitalCity> getCapitalPopls() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from country,city where country.Capital = city.ID order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<capitalCity> capital_cities = new ArrayList<capitalCity>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            capitalCity cap_c = new capitalCity(rset.getString(1), rset.getString(2), rset.getFloat(3));
            capital_cities.add(cap_c);
        }
        return capital_cities;
    }
    /**
     *  all the capital cities in a continent organized by largest population to smallest
     * @return capCityCon
     */

    public ArrayList<capitalCity> getCapCityConLToS() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code and country.Continent='North America' order by city.Population desc ";
        // create array to store Capital City
        ArrayList<capitalCity> capCityCon = new ArrayList<capitalCity>();
        PreparedStatement psTmt = con.prepareStatement(sql);
        ResultSet reSet = psTmt.executeQuery();
        while (reSet.next()) {
            capitalCity cap_cc = new capitalCity(reSet.getString(1),reSet.getString(2),reSet.getFloat(3));
            capCityCon.add(cap_cc);
        }
        return capCityCon;
    }
    /**
     *  all the capital cities in a region organized by largest population to smallest
     * @return capCitReg
     */

    public ArrayList<capitalCity> getCapCitRegLS() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code and country.Region='Caribbean' order by city.Population desc ";
        // create array to store Capital City
        ArrayList<capitalCity> capCitReg = new ArrayList<capitalCity>();
        PreparedStatement psTmt = con.prepareStatement(sql);
        ResultSet reSet = psTmt.executeQuery();
        while (reSet.next()) {
            capitalCity cap_cr = new capitalCity(reSet.getString(1),reSet.getString(2),reSet.getFloat(3));
            capCitReg.add(cap_cr);
        }
        return capCitReg;
    }


    /**
     *  Display function of all the cities in the world organised by largest population to smallest
     * @param cityNum city population in the world list
     */

    public void displayCity(ArrayList<city> cityNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        //  Create Table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 10, 50);
        t.setColumnWidth(1, 10, 50);
        t.setColumnWidth(2, 10, 50);
        t.setColumnWidth(3, 10, 50);
        // add header
        t.addCell("Cities Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("District", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the cities in the world organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (city c: cityNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());

    }
    /**
     *  Display function of Top N populated City in a country.
     * @param Tnp_C population in the world list
     */

    public void displayTopNPopCity(ArrayList<city> Tnp_C)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        //  Create Table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 10, 50);
        t.setColumnWidth(1, 10, 50);
        t.setColumnWidth(2, 10, 50);
        t.setColumnWidth(3, 10, 50);
        // add header
        t.addCell("Cities Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("District", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("This is top 10 populated city in Myanmar country");
        // loop cell and columns with fetch data
        for (city c: Tnp_C)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());

    }
    /**
     *  Display function of all the cities in the country organised by largest population to smallest
     * @param ccnt city population in the country list
     */

    public void displayCityCountry(ArrayList<city> ccnt)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        //  Create Table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 50);
        t.setColumnWidth(2, 7, 50);
        t.setColumnWidth(3, 7, 50);
        // add header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("District", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the cities in South Korea organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (city c: ccnt)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell("South Korea", numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of all the city in the district organised by largest population to smallest
     * @param dcNum city population in a district list
     */

    public void displayCityDistrict(ArrayList<city> dcNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // Create Table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 50);
        t.setColumnWidth(2, 7, 50);
        t.setColumnWidth(3, 7, 50);
        // add header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("District", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the cities in England organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (city c: dcNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of all the cities in Continent organized by largest population to smallest
     * @param ccnt city population in a continent list
     */

    public void displayCityContinent(ArrayList<city> ccnt)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // create table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 50);
        t.setColumnWidth(2, 7, 50);
        t.setColumnWidth(3, 7, 50);
        // add header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("District", numberStyle);
        t.addCell("Population", numberStyle);
        System.out.println("All the cities in Europe organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (city c: ccnt)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());

    }

    /**
     *  Display function of all the cities in a region organized by largest population to smallest
     * @param rcNum city population in a region list
     */

    public void displayRegion(ArrayList<city> rcNum)
    {

        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // create table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 50);
        t.setColumnWidth(2, 7, 50);
        t.setColumnWidth(3, 7, 50);
        // add header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("District", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the cities in South East Asia organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (city rci: rcNum)
        {
            t.addCell(rci.getName(), numberStyle);
            t.addCell(rci.getCountry(), numberStyle);
            t.addCell(rci.getDistrict(), numberStyle);
            t.addCell(String.valueOf(rci.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of all the countries in the world organised by largest population to smallest
     * @param couNum countries population in the world list
     */

    public void displayCountry(ArrayList<country> couNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // Create Table
        Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 50);
        t.setColumnWidth(2, 7, 50);
        t.setColumnWidth(3, 7, 50);
        t.setColumnWidth(4, 7, 50);
        t.setColumnWidth(5, 7, 50);
        // add header
        t.addCell("Country Code", numberStyle);
        t.addCell("Country Name", numberStyle);
        t.addCell("Continent", numberStyle);
        t.addCell("Region", numberStyle);
        t.addCell("Population", numberStyle);
        t.addCell("Capital Ciy", numberStyle);

        System.out.println("All the countries in the world organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (country c: couNum)
        {
            t.addCell(c.getCode(), numberStyle);
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getContinent(), numberStyle);
            t.addCell(c.getRegion(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
            t.addCell(c.getCapital(), numberStyle);
        }

        System.out.println(t.render());

    }

    /**
     *  Display function of all the countires in the South East Asia organized by largest population to smallest
     * @param couNum country population in a region list
     */

    public void displayCountryPopLSRegion(ArrayList<country> couNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // create table
        Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 16);
        t.setColumnWidth(1, 7, 16);
        t.setColumnWidth(2, 7, 16);
        t.setColumnWidth(3, 7, 16);
        t.setColumnWidth(4, 7, 16);
        t.setColumnWidth(5, 7, 40);
        // add header
        t.addCell("Country Code", numberStyle);
        t.addCell("Country Name", numberStyle);
        t.addCell("Continent", numberStyle);
        t.addCell("Region", numberStyle);
        t.addCell("Population", numberStyle);
        t.addCell("Capital Ciy", numberStyle);

        System.out.println("All the countries in South East Asia organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (country c: couNum)
        {
            t.addCell(c.getCode(), numberStyle);
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getContinent(), numberStyle);
            t.addCell(c.getRegion(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
            t.addCell(c.getCapital(), numberStyle);
        }

        System.out.println(t.render());
    }
    /**
     *  Display function of all the countries in a Continent organized by largest population to smallest
     * @param couConNum country population in a continent list
     */

    public void displayCouCon(ArrayList<country> couConNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // create table
        Table t = new Table(6, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 16);
        t.setColumnWidth(1, 7, 16);
        t.setColumnWidth(2, 7, 16);
        t.setColumnWidth(3, 7, 16);
        t.setColumnWidth(4, 7, 16);
        t.setColumnWidth(5, 7, 40);
        // add header
        t.addCell("Country Code", numberStyle);
        t.addCell("Country Name", numberStyle);
        t.addCell("Continent", numberStyle);
        t.addCell("Region", numberStyle);
        t.addCell("Population", numberStyle);
        t.addCell("Capital Ciy", numberStyle);

        System.out.println("All the countries in Europe organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (country c: couConNum)
        {
            t.addCell(c.getCode(), numberStyle);
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getContinent(), numberStyle);
            t.addCell(c.getRegion(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
            t.addCell(c.getCapital(), numberStyle);
        }

        System.out.println(t.render());
    }
    /**
     *  Display function of all the capital cities in the world organized by largest population to smallest
     * @param capcNum capital city population in the world list
     */

    public void displayCapital(ArrayList<capitalCity> capcNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(3, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        t.setColumnWidth(2, 7, 30);
        //  add table header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the capital cities in the world organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (capitalCity c: capcNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }
    /**
     *  Display function of all the capital cities in the region organized by largest population to smallest
     * @param capCRNum capital city population in the world list
     */

    public void dispalyCapCitRegLs(ArrayList<capitalCity> capCRNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(3, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        t.setColumnWidth(2, 7, 30);
        //  add table header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the capital cities in Caribbean organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (capitalCity c: capCRNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }
    /**
     *  Display function of all the capital cities in a continent organised by largest population to smallest
     * @param CCCNum Capital city population in a continent list
     */

    public void displayCapCitCon(ArrayList<capitalCity> CCCNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(3, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        t.setColumnWidth(2, 7, 30);
        //  add table header
        t.addCell("City Name", numberStyle);
        t.addCell("Country", numberStyle);
        t.addCell("Population", numberStyle);

        System.out.println("All the capital cities in North America organised by largest population to smallest");
        // loop cell and columns with fetch data
        for (capitalCity c: CCCNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }


    /**
     * Our application entry point.
     * @param args The command line arguments.
     * @throws SQLException when we can't access to database or something like that.
     **/

    public static void main(String[] args) throws SQLException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // city
        ArrayList<city> cities = a.getCityPopLs();
        a.displayCity(cities);
        ArrayList<city> coucities = a.getCityCountryPopLs();
        a.displayCityCountry(coucities);
        ArrayList<city> cityconti = a.getCityContinentPopLs();
        a.displayCityContinent(cityconti);
        ArrayList<city> d_cities = a.getDistrictPopls();
        a.displayCityDistrict(d_cities);
        ArrayList<city> r_cities = a.getRegionPopls();
        a.displayRegion(r_cities);
        ArrayList<city> Tnp_C = a.getTopNPopCit();
        a.displayTopNPopCity(Tnp_C);

        // country
        ArrayList<country> countries = a.getCountryPopLs();
        a.displayCountry(countries);
        ArrayList<country> countriesRegionLS = a.getCountryPopLsRegion();
        a.displayCountryPopLSRegion(countriesRegionLS);
        ArrayList<country> CouCon = a.getCouCon();
        a.displayCouCon(CouCon);

        // capital city
        ArrayList<capitalCity> capital_cities = a.getCapitalPopls();
        a.displayCapital(capital_cities);
        ArrayList<capitalCity> capital_cities_Continent = a.getCapCityConLToS();
        a.displayCapCitCon(capital_cities_Continent);
        ArrayList<capitalCity> capital_cities_Region = a.getCapCitRegLS();
        a.dispalyCapCitRegLs(capital_cities_Region);
        // Disconnect from database
        a.disconnect();
    }
}

