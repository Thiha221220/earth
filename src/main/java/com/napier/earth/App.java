package com.napier.earth;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
//import org.nocrala.tools.texttablefmt.BorderStyle;
//import org.nocrala.tools.texttablefmt.CellStyle;
//import org.nocrala.tools.texttablefmt.ShownBorders;
//import org.nocrala.tools.texttablefmt.Table;
//import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;


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
            System.out.println("Failed to get country details");
            return null;
        }
    }
    public void displayCountry(ArrayList<country> couNum)
    {


//        CellStyle numberStyle = new CellStyle(HorizontalAlign.right);
//
//        Table t = new Table(2, BorderStyle.DESIGN_FORMAL,
//                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
//
//        t.setColumnWidth(0, 8, 14);
//        t.setColumnWidth(1, 7, 16);
//
//        t.addCell("Countries Name", numberStyle);
//        t.addCell("Population", numberStyle);

        System.out.println("All the countries in the world organised by largest population to smallest");
        for (country c: couNum)
        {
            System.out.println("All the countries in the world organised by largest population to smallest");
            System.out.println(c.getName()+String.valueOf(c.getPopulation()));
//            t.addCell(c.getName(), numberStyle);
//            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }
//        System.out.println(t.render());
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
            System.out.println("Failed to get country details");
            return null;
        }
    }
    public void displayCountryPopLSRegion(ArrayList<country> couNum)
    {
//        CellStyle numberStyle = new CellStyle(HorizontalAlign.right);
//
//        Table t = new Table(2, BorderStyle.DESIGN_FORMAL,
//                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
//
//        t.setColumnWidth(0, 8, 14);
//        t.setColumnWidth(1, 7, 16);
//
//        t.addCell("Countries Name", numberStyle);
//        t.addCell("Population", numberStyle);



//        System.out.println("All the countries in South East Asia organised by largest population to smallest");
//        for (country c: couNum)
//        {
//            t.addCell(c.getName(), numberStyle);
//            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
//        }
        System.out.println("All the countries in South East Asia organised by largest population to smallest");
        for (country c: couNum)
        {

            System.out.println(c.getName()+String.valueOf(c.getPopulation()));
//            t.addCell(c.getName(), numberStyle);
//            t.addCell(String.valueOf(c.getPopulation()), numberStyle);
        }
//        System.out.println(t.render());
    }
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        ArrayList<country> countries = a.getCountryPopLs();
        a.displayCountry(countries);
        ArrayList<country> countriesRegionLS = a.getCountryPopLsRegion();
        a.displayCountryPopLSRegion(countriesRegionLS);
        // Disconnect from database
        a.disconnect();
    }

}

