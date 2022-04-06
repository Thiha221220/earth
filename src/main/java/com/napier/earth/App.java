package com.napier.earth;

/**
 * @author Hein Htet Zaw, Tsawm Nu Ra, Yoon Shwe Lwin, Thiha Htun Htun
 * @version 3.0
 * @since 1.0
 */

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

public class App
{

    private static Connection con = null;
    /**
     * sql connect function with world database
     */
    public void connect(String location, int delay)
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
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+ location +"/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
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

    public static ArrayList<City> getCityPopLs() {
        try {
            //  sql query based on issue
            String sql = "select city.Name, country.Name, city.District, city.Population from country,city where country.Code = city.CountryCode order by city.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store cities
            ArrayList<City> cities = new ArrayList<City>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next()) {
                City ct = new City(rset.getString(1), rset.getString(2), rset.getString(3), rset.getInt(4));
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

    public ArrayList<City> getCityCountryPopLs() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city,country where city.CountryCode='KOR' and city.CountryCode = country.Code order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store city
        ArrayList<City> coucity = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            City cct = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4));
            coucity.add(cct);
        }
        return coucity;
    }

    /**
     *  all the cities in the continent organized by largest population to smallest
     * @return cityconti
     */

    public ArrayList<City> getCityContinentPopLs() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Continent='Europe' order by city.Population desc ";
        // create array to store city
        ArrayList<City> cityconti = new ArrayList<City>();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            City cct = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4));
            cityconti.add(cct);
        }
        return cityconti;
    }
    /**
     *  all the cities in the district organized by largest population to smallest
     * @return d_cities
     */

    public ArrayList<City> getDistrictPopls()
    {
        try
        {
            //  sql query based on issue
            String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.district='England' and city.CountryCode = country.Code order by city.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store city
            ArrayList<City> d_cities = new ArrayList<City>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                City dc = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4));
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

    public ArrayList<City> getRegionPopls() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Region='Southeast Asia' order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store cities
        ArrayList<City> r_cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            City rc = new City(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getInt(4));
            r_cities.add(rc);
        }
        return r_cities;
    }
    /**
     *  The top N populated cities in a country where N is provided by the user.
     * @return TNPop_cities
     */

    public ArrayList<City> getTopNPopCit() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Name = 'Myanmar' order by city.Population desc LIMIT 10";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store top 10 populated cities
        ArrayList<City> TNPop_cities = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            City Tn_C = new City(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getInt(4));
            TNPop_cities.add(Tn_C);
        }
        return TNPop_cities;
    }
    /**
     *  The top N populated cities in the world where N is provided by the user.
     * @return TNPopCit_World
     */

    public ArrayList<City> getTopNPopCitWorld() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code order by city.Population desc LIMIT 10";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store top 10 populated cities
        ArrayList<City> TNPopCit_World = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            City TnC_W = new City(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getInt(4));
            TNPopCit_World.add(TnC_W);
        }
        return TNPopCit_World;
    }

    /**
     * top N populated cities in a continent where N is provided by the user
     * @return topcityconti
     */
    public ArrayList<City> getTopCityContinent(int topccon) throws SQLException {
        try
        {
            //  sql query based on issue
            String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Continent='Asia' order by city.Population desc limit "+topccon;
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<City> topcityconti = new ArrayList<City>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                City tcct = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4));
                topcityconti.add(tcct);
            }
            return topcityconti;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated cities in a continent details");
            return null;
        }
    }

    /**
     *  top N populated cities in a region where N is provided by the user
     * @return cityrgn
     */

    public ArrayList<City> getTopCityRegion(int topcrgn) throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.CountryCode = country.Code and country.Region='Southeast Asia' order by city.Population desc limit "+topcrgn;
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store cities
        ArrayList<City> cityrgn = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next())
        {
            City tcrn = new City(
                    rset.getString(1),
                    rset.getString(2),
                    rset.getString(3),
                    rset.getInt(4));
            cityrgn.add(tcrn);
        }
        return cityrgn;
    }

    /**
     *  top N populated cities in a district where N is provided by the user
     *      * @return topcitydis
     */

    public ArrayList<City> getTopCityDistrict(int topcdst) throws SQLException
    {
        try
        {
            //  sql query based on issue
            String sql = "select city.Name, country.Name, city.District, city.Population from city, country where city.district='England' and city.CountryCode = country.Code order by city.Population desc limit "+topcdst;
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store city
            ArrayList<City> topcitydis = new ArrayList<City>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                City tcdt = new City(rset.getString(1),rset.getString(2),rset.getString(3),rset.getInt(4));
                topcitydis.add(tcdt);
            }
            return topcitydis;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top N city in a district");
            return null;
        }
    }

    /**
     *  The population of a district should be accessible to the organization.
     * @return popdis
     */
    public ArrayList<City> getPopdist( ) throws SQLException {
        //  sql query based on issue
        String sql = "select District, Population from city where District = 'California' ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<City> popdist = new ArrayList<City>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            City cc = new City(rset.getString(1), rset.getInt(2));
            popdist.add(cc);
        }
        return popdist;
    }

    /**
     *  all the country in a region organized by largest population to smallest
     * @return countries1
     */

    public ArrayList<Country> getCountryPopLsRegion()
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where Region = 'Southeast Asia' and country.Capital = city.ID order by Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> countries1 = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country cou = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
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

    public ArrayList<Country> getCouCon()
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where Continent = 'Europe' and country.Capital = city.ID order by country.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> couCon = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country couCons = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
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

    public ArrayList<Country> getCountryPopLs()
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where country.Capital = city.ID order by country.Population desc";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> countries = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country cou = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
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
     *  top The top N populated countries in the world where N is provided by the user.
     * @return t_countries
     */

    public ArrayList<Country> getCountryTopPop(int topcou )
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where country.Capital = city.ID order by country.Population desc limit "+topcou;
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> t_countries = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country cou = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                t_countries.add(cou);
            }
            return t_countries;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the world details");
            return null;
        }
    }

    /**
     *  top N populated countries in a continent where N is provided by the user
     * @return top_cou_con
     */

    public ArrayList<Country> getTopCouContinent(int topcou)
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where country.Capital = city.ID and Continent='North America' order by country.Population desc limit "+topcou;
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> top_cou_con = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country cou = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                top_cou_con.add(cou);
            }
            return top_cou_con;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in a continent details");
            return null;
        }
    }

    /**
     *  top N populated countries in a region where N is provided by the user
     * @return top_cou_reg
     */

    public ArrayList<Country> getTopCouRegion(int topcou)
    {
        try
        {
            //  sql query based on issue
            String sql = "select country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name from country,city where country.Capital = city.ID and Region='Caribbean' order by country.Population desc limit "+topcou;
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> top_cou_reg = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country cou = new Country(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6));
                top_cou_reg.add(cou);
            }
            return top_cou_reg;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in a region details");
            return null;
        }
    }

    /**
     *  The population of a continent should be accessible to the organization.
     * @return popcont
     */
    public ArrayList<Country> getPopcont( ) throws SQLException {
        //  sql query based on issue
        String sql = "select country.Continent, country.Population from country where country.Continent = 'Asia' ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<Country> popcont = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Country cou = new Country(rset.getString(1), rset.getInt(2));
            popcont.add(cou);
        }
        return popcont;
    }

    /**
     *  all the capital cities in the world organized by largest population to smallest
     * @return capital_cities
     */

    public ArrayList<CapitalCity> getCapitalPopls() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from country,city where country.Capital = city.ID order by city.Population desc";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<CapitalCity> capital_cities = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            CapitalCity cap_c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getInt(3));
            capital_cities.add(cap_c);
        }
        return capital_cities;
    }
    /**
     *  all the capital cities in a continent organized by largest population to smallest
     * @return capCityCon
     */

    public ArrayList<CapitalCity> getCapCityConLToS() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code and country.Continent='North America' order by city.Population desc ";
        // create array to store Capital City
        ArrayList<CapitalCity> capCityCon = new ArrayList<CapitalCity>();
        PreparedStatement psTmt = con.prepareStatement(sql);
        ResultSet reSet = psTmt.executeQuery();
        while (reSet.next()) {
            CapitalCity cap_cc = new CapitalCity(reSet.getString(1),reSet.getString(2),reSet.getInt(3));
            capCityCon.add(cap_cc);
        }
        return capCityCon;
    }
    /**
     *  all the capital cities in a region organized by largest population to smallest
     * @return capCitReg
     */

    public ArrayList<CapitalCity> getCapCitRegLS() throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from city, country where city.CountryCode = country.Code and country.Region='Caribbean' order by city.Population desc ";
        // create array to store Capital City
        ArrayList<CapitalCity> capCitReg = new ArrayList<CapitalCity>();
        PreparedStatement psTmt = con.prepareStatement(sql);
        ResultSet reSet = psTmt.executeQuery();
        while (reSet.next()) {
            CapitalCity cap_cr = new CapitalCity(reSet.getString(1),reSet.getString(2),reSet.getInt(3));
            capCitReg.add(cap_cr);
        }
        return capCitReg;
    }

    /**
     *  The top N populated capital cities in the world where N is provided by the user.
     * @return capital_cities
     */

    public ArrayList<CapitalCity> getTCAWPopls(int times) throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from country,city where country.Capital = city.ID order by city.Population desc limit "+times;
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<CapitalCity> capital_cities = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            CapitalCity cap_c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getInt(3));
            capital_cities.add(cap_c);
        }
        return capital_cities;
    }
    /**
     *  The top N populated capital cities in the continent where N is provided by the user.
     * @return capital_cities
     */

    public ArrayList<CapitalCity> getTCACPopls(int times) throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from country,city where country.Capital = city.ID and country.continent = 'Oceania' order by city.Population desc limit "+times;
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<CapitalCity> capital_cities = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            CapitalCity cap_c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getInt(3));
            capital_cities.add(cap_c);
        }
        return capital_cities;
    }
    /**
     *  The top N populated capital cities in the region where N is provided by the user.
     * @return capital_cities
     */

    public ArrayList<CapitalCity> getTCARPopls(int times) throws SQLException {
        //  sql query based on issue
        String sql = "select city.Name, country.Name, city.Population from country,city where country.Capital = city.ID and country.Region = 'Middle East' order by city.Population desc limit "+times;
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<CapitalCity> capital_cities = new ArrayList<CapitalCity>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            CapitalCity cap_c = new CapitalCity(rset.getString(1), rset.getString(2), rset.getInt(3));
            capital_cities.add(cap_c);
        }
        return capital_cities;
    }

    /**
     *  The population of people, people living in cities, and people not living in cities in each continent.
     * @return pop_cities
     */
    public ArrayList<Population> getPopcon() throws SQLException {
        //  sql query based on issue
        String sql = "Select country.Continent, SUM(country.Population), SUM(city.Population), SUM(country.Population)-SUM(city.Population) from country, city GROUP BY Continent";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<Population> pop_con = new ArrayList<Population>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Population pop= new Population (rset.getString(1), rset.getLong(2), rset.getLong(3), rset.getLong(4));
            pop_con.add (pop);
        }
        return pop_con;
    }

    /**
     *  The population of the world
     * @return popw
     */

    public ArrayList<Country> getPopsW() throws SQLException {
        //  sql query based on issue
        String sql = "select Population from country";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<Country> popw = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Country countryW = new Country(rset.getInt(1));
            popw.add(countryW);
        }
        return popw;
    }
    /**
     *  The number of people who speak Chinese, English, Hindi, Spanish and Arabic from the greatest number to the smallest list
     * @return ints
     */

    public ArrayList<Country>[] getLanguagePops() throws SQLException {
        //  sql query based on issue
        String sql = "select population from country";
        String sqlE = "select country.population from countrylanguage, country where countrylanguage.CountryCode = country.Code and countrylanguage.Language = 'English' and countrylanguage.IsOfficial = 'T'";
        String sqlC = "select country.population from countrylanguage, country where countrylanguage.CountryCode = country.Code and countrylanguage.Language = 'Chinese' and countrylanguage.IsOfficial = 'T'";
        String sqlA = "select country.population from countrylanguage, country where countrylanguage.CountryCode = country.Code and countrylanguage.Language = 'Arabic' and countrylanguage.IsOfficial = 'T'";
        String sqlH = "select country.population from countrylanguage, country where countrylanguage.CountryCode = country.Code and countrylanguage.Language = 'Hindi' and countrylanguage.IsOfficial = 'T'";
        String sqlS = "select country.population from countrylanguage, country where countrylanguage.CountryCode = country.Code and countrylanguage.Language = 'Spanish' and countrylanguage.IsOfficial = 'T'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store world population
        ArrayList<Country> popw = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        PreparedStatement pstmt1 = con.prepareStatement(sqlE);
        // create array to store number of people who speak English
        ArrayList<Country> pope = new ArrayList<Country>();
        ResultSet rset1 = pstmt1.executeQuery();
        PreparedStatement pstmt2 = con.prepareStatement(sqlC);
        // create array to store number of people who speak Chinese
        ArrayList<Country> popc = new ArrayList<Country>();
        ResultSet rset2 = pstmt2.executeQuery();
        PreparedStatement pstmt3 = con.prepareStatement(sqlA);
        // create array to store number of people who speak Arabic
        ArrayList<Country> popa = new ArrayList<Country>();
        ResultSet rset3 = pstmt3.executeQuery();
        PreparedStatement pstmt4 = con.prepareStatement(sqlH);
        // create array to store number of people who speak Hindi
        ArrayList<Country> poph = new ArrayList<Country>();
        ResultSet rset4 = pstmt4.executeQuery();
        PreparedStatement pstmt5 = con.prepareStatement(sqlS);
        // create array to store number of people who speak Spanish
        ArrayList<Country> pops = new ArrayList<Country>();
        ResultSet rset5 = pstmt5.executeQuery();
        while (rset.next()) {
            Country countryW = new Country(rset.getInt(1));
            popw.add(countryW);
        }
        while (rset1.next()) {
            Country countryE = new Country(rset1.getInt(1));
            pope.add(countryE);
        }
        while (rset2.next()) {
            Country countryC = new Country(rset2.getInt(1));
            popc.add(countryC);
        }
        while (rset3.next()) {
            Country countryA = new Country(rset3.getInt(1));
            popa.add(countryA);
        }
        while (rset4.next()) {
            Country countryH = new Country(rset4.getInt(1));
            poph.add(countryH);
        }
        while (rset5.next()) {
            Country countryS = new Country(rset5.getInt(1));
            pops.add(countryS);
        }
        ArrayList<Country>[] ints = new ArrayList[]{popw, pope, popc, popa, poph, pops};
        return ints;
    }

    /**
     *  Display function of all the cities in the world organised by largest population to smallest
     * @param cityNum city population in the world list
     */

    public static void displayCity(ArrayList<City> cityNum)
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
        for (City c: cityNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());

    }
    /**
     *  The population of people, people living in cities, and people not living in cities in each region.
     * @return PepPopReg the population of people in each region
     */
    public ArrayList<Population> getPepPogReg() throws SQLException {
        //  sql query based on issue
        String sql = "Select country.Region, SUM(country.Population), SUM(city.Population), SUM(country.Population)-SUM(city.Population) from country, city where country.Code = city.CountryCode GROUP BY Region";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<Population> PepPopReg = new ArrayList<Population>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Population PepPop= new Population (rset.getString(1), rset.getLong(2), rset.getLong(3), rset.getLong(4));
            PepPopReg.add (PepPop);
        }
        return PepPopReg;
    }
    /**
     *  The population of a region should be accessible to the organisation.
     * @return PopReg the population of the region.
     */

    public ArrayList<Country> getPopReg() throws SQLException {
        //  sql query based on issue
        String sql = "select Population from country where country.Region ='Caribbean'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        // create array to store capital_cities
        ArrayList<Country> PopRegs = new ArrayList<Country>();
        ResultSet rset = pstmt.executeQuery();
        while (rset.next()) {
            Country PopReg = new Country(rset.getInt(1));
            PopRegs.add(PopReg);
        }
        return PopRegs;
    }
    /**
     *  Display function of Top N populated Cities in a country.
     * @param Tnp_C population in the world list
     */

    public static void displayTopNPopCity(ArrayList<City> Tnp_C)
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

        System.out.println("This is top 10 populated cities in Myanmar country");
        // loop cell and columns with fetch data
        for (City c: Tnp_C)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());

    }
    /**
     *  Display function of Top N populated Cities in the world.
     * @param TnpC_W population in the world list
     */

    public static void displayTopNPopCityWorld(ArrayList<City> TnpC_W)
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

        System.out.println("This is top 10 populated cities in the world");
        // loop cell and columns with fetch data
        for (City c: TnpC_W)
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

    public static void displayCityCountry(ArrayList<City> ccnt)
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
        for (City c: ccnt)
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

    public static void displayCityDistrict(ArrayList<City> dcNum)
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
        for (City c: dcNum)
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

    public static void displayCityContinent(ArrayList<City> ccnt)
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
        for (City c: ccnt)
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

    public static void displayRegion(ArrayList<City> rcNum)
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
        for (City rci: rcNum)
        {
            t.addCell(rci.getName(), numberStyle);
            t.addCell(rci.getCountry(), numberStyle);
            t.addCell(rci.getDistrict(), numberStyle);
            t.addCell(String.valueOf(rci.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of top N populated cities in a continent where N is provided by the user.
     * @param tccnt the top N population of country in the world list
     * @param topccon
     */

    public static void displayTopCityContinent(ArrayList<City> tccnt, int topccon)
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
        System.out.println("Top "+topccon+" Populated cities in Asia where "+topccon+" is provided by the user");
        // loop cell and columns with fetch data
        for (City c: tccnt)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of top N populated cities in a region where N is provided by the user.
     * @param tcrgn the top N population of country in the world list
     * @param topcrgn
     */
    public static void displayTopCityRegion(ArrayList<City> tcrgn, int topcrgn)
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

        System.out.println("Top "+topcrgn+" Populated cities in South East Asia where "+topcrgn+" is provided by the user");
        // loop cell and columns with fetch data
        for (City rci: tcrgn)
        {
            t.addCell(rci.getName(), numberStyle);
            t.addCell(rci.getCountry(), numberStyle);
            t.addCell(rci.getDistrict(), numberStyle);
            t.addCell(String.valueOf(rci.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of top N populated cities in a district where N is provided by the user.
     * @param tcdst the top N population of country in the world list
     * @param topcdst
     */

    public static void displayTopCityDistrict(ArrayList<City> tcdst, int topcdst)
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

        System.out.println("Top "+topcdst+" Populated cities in England where "+topcdst+" is provided by the user");
        // loop cell and columns with fetch data
        for (City c: tcdst)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(c.getDistrict(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of populated people in a district
     * @param ccNum the population in a district list
     */
    public void displayPopdist(ArrayList<City> ccNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(2, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        //  add table header
        t.addCell("Populated people in California" );
        // loop cell and columns with fetch data
        System.out.println("Population Report of California ");
        long sum = 0;
//
        for (City c: ccNum){
            sum += c.getPopulation();
        }
        t.addCell(String.valueOf(sum), numberStyle);
        System.out.println(t.render());
    }

    /**
     *  Display function of the top N populated capital cities in the world where N is provided by the user.
     * @param capcNum capital city population in the world list
     */

    public static void displayTCAW(ArrayList<CapitalCity> capcNum, int times)
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

        System.out.println("The top "+times+" populated capital cities in the world where "+times+" is provided by the user.");
        // loop cell and columns with fetch data
        for (CapitalCity c: capcNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }
    /**
     *  Display function of the top N populated capital cities in the continent where N is provided by the user.
     * @param capconNum capital city population in the continent list
     */

    public void displayTCAC(ArrayList<CapitalCity> capconNum, int times)
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

        System.out.println("The top "+times+" populated capital cities in Oceania where "+times+" is provided by the user.");
        // loop cell and columns with fetch data
        for (CapitalCity c: capconNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }
    /**
     *  Display function of the top N populated capital cities in the region where N is provided by the user.
     * @param caprNum capital city population in the region list
     */

    public static void displayTCAR(ArrayList<CapitalCity> caprNum, int times) {
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
        t.addCell("Population", numberStyle);System.out.println("The top "+times+" populated capital cities in the Middle East where "+times+" is provided by the user.");
        // loop cell and columns with fetch data
        for (CapitalCity c: caprNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of all the countries in the world organised by largest population to smallest
     * @param couNum countries population in the world list
     */

    public static void displayCountry(ArrayList<Country> couNum)
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
        for (Country c: couNum)
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

    public static void displayCountryPopLSRegion(ArrayList<Country> couNum)
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
        for (Country c: couNum)
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

    public static void displayCouCon(ArrayList<Country> couConNum)
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
        for (Country c: couConNum)
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
     *  Display function of top N populated countries in the world where N is provided by the user.
     * @param couNum the top N population of country in the world list
     * @param topcou
     */

    public static void displayTopCountryPop(ArrayList<Country> couNum, int topcou)
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

        System.out.println( "The top "+ topcou + " populated countries in the world where " + topcou + " is provided by the user");
        // loop cell and columns with fetch data
        for (Country c: couNum)
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
     *  Display function of top N populated countries in a continent where N is provided by the user.
     * @param couNum the top N population of country in a continent list
     * @param topcou
     */

    public static void displayTopCouContPop(ArrayList<Country> couNum, int topcou)
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

        System.out.println( "The top "+ topcou + " populated countries in North America where " + topcou + " is provided by the user");
        // loop cell and columns with fetch data
        for (Country c: couNum)
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
     *  Display function of top N populated countries in a region where N is provided by the user.
     * @param couNum the top N population of country in a region list
     * @param topcou
     */

    public static void displayTopCouRegPop(ArrayList<Country> couNum, int topcou)
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

        System.out.println( "The top "+ topcou + " populated countries in Caribbean where " + topcou + " is provided by the user");
        // loop cell and columns with fetch data
        for (Country c: couNum)
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

    public void displayPopcont(ArrayList<Country> couNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(2, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        //  add table header
        t.addCell("Populated People in Asia" );
        // loop cell and columns with fetch data
        System.out.println("Population Report of Asia ");
        long sum = 0;
//
        for (Country c: couNum){
            sum += c.getPopulation();
        }
        t.addCell(String.valueOf(sum), numberStyle);
        System.out.println(t.render());
    }


    /**
     *  Display function of all the capital cities in the world organized by largest population to smallest
     * @param capcNum capital city population in the world list
     */

    public static void displayCapital(ArrayList<CapitalCity> capcNum)
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
        for (CapitalCity c: capcNum)
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

    public static void dispalyCapCitRegLs(ArrayList<CapitalCity> capCRNum)
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
        for (CapitalCity c: capCRNum)
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

    public void displayCapCitCon(ArrayList<CapitalCity> CCCNum)
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
        for (CapitalCity c: CCCNum)
        {
            t.addCell(c.getName(), numberStyle);
            t.addCell(c.getCountry(), numberStyle);
            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  The population of the city
     * @return ctypop
     */

    public ArrayList<City> getCityPopulation()
    {
        try
        {
            //  sql query based on issue
            String sql = "select Population from city where Name='London'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<City> ctypop = new ArrayList<City>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                City cty = new City(rset.getInt(1));
                ctypop.add(cty);
            }
            System.out.println(ctypop);
            return ctypop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population report of a city");
            return null;
        }
    }

    /**
     *  The population of the country
     * @return coupop
     */

    public ArrayList<Country> getCountryPopulation()
    {
        try
        {
            //  sql query based on issue
            String sql = "select Population from country where Name='Myanmar'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            // create array to store country
            ArrayList<Country> coupop = new ArrayList<Country>();
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Country cnt = new Country(rset.getInt(1));
                coupop.add(cnt);
            }
            return coupop;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population report of a country");
            return null;
        }
    }

    /**
     *  The population of people, people living in cities, and people not living in cities in each country
     * @return pplpop
     */

    public ArrayList<Population> getCntCitynotCity()
    {
        try
        {
            //  sql query based on issue
            String sql = "Select country.Name, country.Population, SUM(city.Population), country.Population-SUM(city.population) from country, city where country.Code = city.CountryCode GROUP BY city.CountryCode";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ArrayList<Population> pplcnc = new ArrayList<Population>();
            // create array to store country
            ResultSet rset = pstmt.executeQuery();
            while (rset.next())
            {
                Population cntc = new Population(rset.getString(1),rset.getLong(2), rset.getLong(3), rset.getLong(4));
                pplcnc.add(cntc);
            }
            return pplcnc;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population report of people living in cities and not living in cities");
            return null;
        }
    }


    /**
     * Display function of population report of a city
     * @param ctypop population of a country
     */
    public static void displayCityPopulation(ArrayList<City> ctypop){
        System.out.println("Population Report of a City");

        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(2, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 20);
        //  add table header
        t.addCell("Population of London", numberStyle);
        long cp = 0;
        // loop cell and columns with fetch data
        for (City c: ctypop)
        {
            cp = c.getPopulation();
        }
        t.addCell(String.valueOf(cp), numberStyle);
        System.out.println(t.render());
    }

    /**
     * Display function of population report of a country
     * @param coupop population of a country
     */
    public static void displayCountryPopulation(ArrayList<Country> coupop){
        System.out.println("Population Report of a Country");

        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(2, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 20);
        //  add table header
        t.addCell("Population of Myanmar", numberStyle);
        long cnp = 0;
        // loop cell and columns with fetch data
        for (Country c: coupop)
        {
            cnp = c.getPopulation();
        }
        t.addCell(String.valueOf(cnp), numberStyle);
        System.out.println(t.render());
    }

    /**
     *  Display function of The population of people, people living in cities, and people not living in cities in each country
     * @param pplcnc
     */

    public void displayCntCitynotCity(ArrayList<Population> pplcnc)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        t.setColumnWidth(2, 7, 40);
        t.setColumnWidth(3, 7, 30);
        //  add table header
        t.addCell("Country Name", numberStyle);
        t.addCell("Total Population", numberStyle);
        t.addCell("People in Cities", numberStyle);
        t.addCell("People not in Cities", numberStyle);

        System.out.println("The population of people, people living in cities, and people not living in cities in each country");
        // loop cell and columns with fetch data
        // 2 decimal value
        DecimalFormat df = new DecimalFormat("####0.00");
        for (Population p: pplcnc)
        {
            double LivingPercent = ((double)p.getLiving()/p.getTotal())*100;
            double NotLivingPercent = ((double)p.getNotliving()/p.getTotal())*100;
            t.addCell(p.getName(), numberStyle);
            t.addCell(String.valueOf(p.getTotal()), numberStyle);
            t.addCell(String.valueOf(p.getLiving())+"("+String.valueOf(df.format(LivingPercent))+"%)", numberStyle);
            t.addCell(String.valueOf(p.getNotliving())+"("+String.valueOf(df.format(NotLivingPercent))+"%)", numberStyle);
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of populated people living in cities, and people not living in cities in each continent.
     * @param popNum the population people living in cities, and people not living in cities in each continent list
     */

    public static void displayPopcon(ArrayList<Population> popNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // create table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 8, 50);
        t.setColumnWidth(2, 8, 50);
        t.setColumnWidth(3, 8, 50);
        // add header
        t.addCell("Name", numberStyle);
        t.addCell("Total Population", numberStyle);
        t.addCell("People living in cities", numberStyle);
        t.addCell("People not living in cities", numberStyle);

        System.out.println( "Population of people living in cities, and people not living in cities in each continent.");
        // loop cell and columns with fetch data
        // 2 decimal value
        DecimalFormat df = new DecimalFormat("####0.00");
        for (int i = 0; i<popNum.size(); i++)
        {

            if (i == 6){
                t.addCell("Antarctica", numberStyle);
                t.addCell("0(0%)", numberStyle);
                t.addCell("0(0%)", numberStyle);
                t.addCell("0(0%)", numberStyle);

            }

            else{
                double LivingPercent = ((double)popNum.get(i).getLiving()/popNum.get(i).getTotal())*100;
                double NotLivingPercent = ((double)popNum.get(i).getNotliving()/popNum.get(i).getTotal())*100;
                t.addCell(popNum.get(i).getName(), numberStyle);
                t.addCell(String.valueOf(popNum.get(i).getTotal()), numberStyle);
                t.addCell(String.valueOf(popNum.get(i).getLiving())+"("+String.valueOf(df.format(LivingPercent))+"%)", numberStyle);
                t.addCell(String.valueOf(popNum.get(i).getNotliving())+"("+String.valueOf(df.format(NotLivingPercent))+"%)", numberStyle);
            }
        }

        System.out.println(t.render());
    }

    /**
     *  Display function of the population of the world should be accessible to the organisation.
     * @param CCCNum the population of the world list
     */

    public void displayPopW(ArrayList<Country> CCCNum)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(2, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        //  add table header
        System.out.println("The Population of the world");
        t.addCell("The population of the world");
        // loop cell and columns with fetch data
        long sum = 0;
        // total population
        for (Country c: CCCNum){
            sum += c.getPopulation();
        }
        t.addCell(String.valueOf(sum), numberStyle);
        System.out.println(t.render());
    }

    /**
     *  Display function of The number of people who speak Chinese, English, Hindi, Spanish and Arabic from the greatest number to smallest, including the percentage of the world population
     * @param args The number of people who speak Chinese, English, Hindi, Spanish and Arabic from the greatest number to the smallest list
     */

    public void displayPopE(ArrayList<Country>[] args) throws SQLException {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(3, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        t.setColumnWidth(2, 7, 40);

        System.out.println("The number of people who speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest, including the percentage of the world population");

        long sum = 0;
        long sume = 0;
        long sumc = 0;
        long suma = 0;
        long sumh = 0;
        long sums = 0;
        // 2 decimal value
        DecimalFormat df = new DecimalFormat("####0.00");
        // languages
        String[] language = {"Chinese","English","Hindi","Spanish","Arabic"};
        int i = 0;
        // sum population
        for (Country c: args[0]) {
            sum += c.getPopulation();
        }
        for (Country c: args[1]) {
            sume += c.getPopulation();
        }
        for (Country c: args[2]) {
            sumc += c.getPopulation();
        }
        for (Country c: args[3]) {
            suma += c.getPopulation();
        }
        for (Country c: args[4]) {
            sumh += c.getPopulation();
        }
        for (Country c: args[5]) {
            sums += c.getPopulation();
        }
        // population percentage
        double e = ((double) sume/sum)*100;
        double c = ((double) sumc/sum)*100;
        double a = ((double) suma/sum)*100;
        double h = ((double) sumh/sum)*100;
        double s = ((double) sums/sum)*100;
        //  add table header
        t.addCell("Language", numberStyle);
        t.addCell("Population", numberStyle);
        t.addCell("Population Percentage", numberStyle);
        // cell and columns
        t.addCell(String.valueOf(language[0]), numberStyle);
        t.addCell(String.valueOf(sumc), numberStyle);
        t.addCell(String.valueOf(df.format(c)+"%"), numberStyle);
        t.addCell(String.valueOf(language[1]), numberStyle);
        t.addCell(String.valueOf(sume), numberStyle);
        t.addCell(String.valueOf(df.format(e)+"%"), numberStyle);
        t.addCell(String.valueOf(language[2]), numberStyle);
        t.addCell(String.valueOf(sumh), numberStyle);
        t.addCell(String.valueOf(df.format(h)+"%"), numberStyle);
        t.addCell(String.valueOf(language[3]), numberStyle);
        t.addCell(String.valueOf(sums), numberStyle);
        t.addCell(String.valueOf(df.format(s)+"%"), numberStyle);
        t.addCell(String.valueOf(language[4]), numberStyle);
        t.addCell(String.valueOf(suma), numberStyle);
        t.addCell(String.valueOf(df.format(a)+"%"), numberStyle);

        System.out.println(t.render());
    }
    /**
     *  Display function of the population of a region should be accessible to the organisation.
     * @param PPRs the population of the region list
     */

    public void displayPopReg(ArrayList<Country> PPRs)
    {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.LEFT);
        //  Create Table
        Table t = new Table(2, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 7, 40);
        //  add table header
        System.out.println("The Population of the Caribbean");
        t.addCell("The population of the a Region Caribbean");
        // loop cell and columns with fetch data
        long sum = 0;
        // total population
        for (Country c: PPRs){
            sum += c.getPopulation();
        }
        t.addCell(String.valueOf(sum), numberStyle);
        System.out.println(t.render());
    }
    public void displayPepPopReg(ArrayList<Population> PPR) {
        CellStyle numberStyle = new CellStyle(HorizontalAlign.RIGHT);
        // create table
        Table t = new Table(4, BorderStyle.DESIGN_TUBES_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        //  defined column with widths
        t.setColumnWidth(0, 8, 50);
        t.setColumnWidth(1, 8, 50);
        t.setColumnWidth(2, 8, 50);
        t.setColumnWidth(3, 8, 50);
        // add header
        t.addCell("Region Name", numberStyle);
        t.addCell("Total Population", numberStyle);
        t.addCell("People living in cities", numberStyle);
        t.addCell("People not living in cities", numberStyle);

        System.out.println( "Population of people living in cities, and people not living in cities in each Region.");
        // loop cell and columns with fetch data
        // 2 decimal value
        DecimalFormat df = new DecimalFormat("####0.00");
        for (int i = 0; i<PPR.size(); i++)
        {

            if (i == 6){
                t.addCell("Antarctica", numberStyle);
                t.addCell("0(0%)", numberStyle);
                t.addCell("0(0%)", numberStyle);
                t.addCell("0(0%)", numberStyle);

            }

            else{
                double LivingPercent = ((double)PPR.get(i).getLiving()/PPR.get(i).getTotal())*100;
                double NotLivingPercent = ((double)PPR.get(i).getNotliving()/PPR.get(i).getTotal())*100;
                t.addCell(PPR.get(i).getName(), numberStyle);
                t.addCell(String.valueOf(PPR.get(i).getTotal()), numberStyle);
                t.addCell(String.valueOf(PPR.get(i).getLiving())+"("+String.valueOf(df.format(LivingPercent))+"%)", numberStyle);
                t.addCell(String.valueOf(PPR.get(i).getNotliving())+"("+String.valueOf(df.format(NotLivingPercent))+"%)", numberStyle);
            }
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
        if(args.length < 1){
            a.connect("localhost:33060", 0);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

//        // city
        ArrayList<City> cities = a.getCityPopLs();
        a.displayCity(cities);
        ArrayList<City> coucities = a.getCityCountryPopLs();
        a.displayCityCountry(coucities);
        ArrayList<City> cityconti = a.getCityContinentPopLs();
        a.displayCityContinent(cityconti);
        ArrayList<City> d_cities = a.getDistrictPopls();
        a.displayCityDistrict(d_cities);
        ArrayList<City> r_cities = a.getRegionPopls();
        a.displayRegion(r_cities);
        ArrayList<City> Tnp_C = a.getTopNPopCit();
        a.displayTopNPopCity(Tnp_C);
        ArrayList<City> TnpC_W = a.getTopNPopCitWorld();
        a.displayTopNPopCityWorld(TnpC_W);
        int tpcity = 10;
        ArrayList<City> topcityconti = a.getTopCityContinent(tpcity);
        a.displayTopCityContinent(topcityconti,tpcity);
        ArrayList<City> topcityrgn = a.getTopCityRegion(tpcity);
        a.displayTopCityRegion(topcityrgn,tpcity);
        ArrayList<City> topcitydst = a.getTopCityDistrict(tpcity);
        a.displayTopCityDistrict(topcitydst,tpcity);
        ArrayList<City> ctypop = a.getCityPopulation();
        a.displayCityPopulation(ctypop);
        ArrayList<City> popdist = a.getPopdist();
        a.displayPopdist(popdist);

        // country
        ArrayList<Country> countries = a.getCountryPopLs();
        a.displayCountry(countries);
        ArrayList<Country> countriesRegionLS = a.getCountryPopLsRegion();
        a.displayCountryPopLSRegion(countriesRegionLS);
        ArrayList<Country> CouCon = a.getCouCon();
        a.displayCouCon(CouCon);
        int topcou = 10;
        ArrayList<Country> t_countries = a.getCountryTopPop(topcou);
        a.displayTopCountryPop(t_countries,topcou);
        ArrayList<Country> top_con_cou = a.getTopCouContinent(topcou);
        a.displayTopCouContPop(top_con_cou,topcou);
        ArrayList<Country> top_con_reg = a.getTopCouRegion(topcou);
        a.displayTopCouRegPop(top_con_reg,topcou);

        ArrayList<Country> coupop = a.getCountryPopulation();
        a.displayCountryPopulation(coupop);
        ArrayList<Country> popcont = a.getPopcont();
        a.displayPopcont(popcont);

        // capital city
        int times = 10;

        ArrayList<CapitalCity> capital_cities = a.getCapitalPopls();
        a.displayCapital(capital_cities);

        ArrayList<CapitalCity> tCAW = a.getTCAWPopls(times);
        a.displayTCAW(tCAW,times);
        ArrayList<CapitalCity> tCAC = a.getTCACPopls(times);
        a.displayTCAC(tCAC,times);
        ArrayList<CapitalCity> tCAR = a.getTCARPopls(times);
        a.displayTCAR(tCAR,times);

        ArrayList<CapitalCity> capital_cities_Continent = a.getCapCityConLToS();
        a.displayCapCitCon(capital_cities_Continent);
        ArrayList<CapitalCity> capital_cities_Region = a.getCapCitRegLS();
        a.dispalyCapCitRegLs(capital_cities_Region);

        //Population
        ArrayList<Population> ctyntcty = a.getCntCitynotCity();
        a.displayCntCitynotCity(ctyntcty);
        ArrayList<Population> pop_con = a.getPopcon();
        a.displayPopcon(pop_con);
        ArrayList<Population> PPR = a.getPepPogReg();
        a.displayPepPopReg(PPR);

        //Population of the world and language
        ArrayList<Country> popw = a.getPopsW();
        a.displayPopW(popw);
        ArrayList<Country>[] pope = a.getLanguagePops();
        a.displayPopE(pope);
        ArrayList<Country> PPRs = a.getPopReg();
        a.displayPopReg(PPRs);
//         Disconnect from database
        a.disconnect();
    }

}