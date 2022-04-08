package com.napier.earth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }
    @Test
    void getCityPopLs() {
        ArrayList<City> cities = app.getCityPopLs();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCity(cities,"cities.md");
        City cp = null;

//        assertNotNull(cities);
//        assertEquals(cities.size() > 0, true);
//        app.displayCity(cities,"cities.md");

        for (City c: cities) {
            if (c.getName().equals("Mumbai (Bombay)")) {
                cp = c;
                break;
            }
        }
//        Assertions.assertEquals("Mumbai (Bombay)",cp.getName());
//        Assertions.assertEquals("India",cp.getCountry());
//        Assertions.assertEquals("Maharashtra",cp.getDistrict());
        Assertions.assertEquals(105000000,cp.getPopulation(),"Value are not equal");
        System.out.println("The info is correct");
    }
    @Test
    void getCityCountryPopLs() throws SQLException {
        ArrayList<City> cities = app.getCityCountryPopLs();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCityCountry(cities,"cityincountry.md");
    }

    @Test
    void getCityContinentPopLs() throws SQLException {
        ArrayList<City> cities = app.getCityContinentPopLs();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCityContinent(cities,"cityincontinent.md");
    }

    @Test
    void getDistrictPopls() {
        ArrayList<City> cities = app.getDistrictPopls();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCityDistrict(cities,"cityindistrict.md");
    }

    @Test
    void getRegionPopls() throws SQLException {
        ArrayList<City> cities = app.getRegionPopls();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayRegion(cities,"cityinregion.md");
    }

    @Test
    void getTopNPopCit() throws SQLException {
        ArrayList<City> cities = app.getTopNPopCit();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopNPopCity(cities,"topcity.md");
    }

    @Test
    void getTopNPopCitWorld() throws SQLException {
        ArrayList<City> cities = app.getTopNPopCitWorld();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopNPopCityWorld(cities,"topcityworld.md");
    }

    @Test
    void getTopCityContinent() throws SQLException {
        ArrayList<City> cities = app.getTopCityContinent(10);
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopCityContinent(cities, 10,"topcityincontinent.md");
    }

    @Test
    void getTopCityRegion() throws SQLException {
        ArrayList<City> cities = app.getTopCityRegion(10);
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopCityRegion(cities, 10,"topcityinregion");
    }

    @Test
    void getTopCityDistrict() throws SQLException {
        ArrayList<City> cities = app.getTopCityDistrict(10);
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopCityDistrict(cities, 10,"topcityindistrict.md");
    }

    @Test
    void getCountryPopLsRegion() {
        ArrayList<Country> countries = app.getCountryPopLsRegion();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCountryPopLSRegion(countries,"countryinregion.md");
    }

    @Test
    void getCouCon() {
        ArrayList<Country> countries = app.getCouCon();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCouCon(countries,"countryincontinent.md");
    }

    @Test
    void getCountryPopLs() {
        ArrayList<Country> countries = app.getCountryPopLs();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCountry(countries,"countriesinworld.md");
    }


    @Test
    void getCountryTopPop() {
        ArrayList<Country> countries = app.getCountryTopPop(10);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayTopCountryPop(countries, 10,"topcouinworld.md");
    }

    @Test
    void getTopCouContinent() {
        ArrayList<Country> countries = app.getTopCouContinent(10);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayTopCouContPop(countries, 10,"topcouincontinent.md");
    }

    @Test
    void getTopCouRegion() {
        ArrayList<Country> countries = app.getTopCouRegion(10);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayTopCouRegPop(countries, 10,"topcouinregion.md");
    }

    @Test
    void getCapitalPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getCapitalPopls();
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayCapital(capCities,"capcityinworld.md");
    }

    @Test
    void getCapCityConLToS() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getCapCityConLToS();
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayCapCitCon(capCities,"capcityincontinent.md");
    }

    @Test
    void getCapCitRegLS() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getCapCitRegLS();
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.dispalyCapCitRegLs(capCities,"capcityinregion.md");
    }

    @Test
    void getTCAWPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getTCAWPopls(10);
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayTCAW(capCities, 10,"topcapcityinworld.md");
    }

    @Test
    void getTCACPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getTCACPopls(10);
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayTCAC(capCities, 10,"topcapcityincontinent.md");
    }

    @Test
    void getTCARPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getTCARPopls(10);
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayTCAR(capCities, 10,"topcapcityinregion.md");
    }
}