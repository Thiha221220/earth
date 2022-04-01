package com.napier.earth;

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
        ArrayList<city> cities = app.getCityPopLs();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCity(cities);
    }
    @Test
    void getCityCountryPopLs() throws SQLException {
        ArrayList<city> cities = app.getCityCountryPopLs();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCityCountry(cities);
    }

    @Test
    void getCityContinentPopLs() throws SQLException {
        ArrayList<city> cities = app.getCityContinentPopLs();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCityContinent(cities);
    }

    @Test
    void getDistrictPopls() {
        ArrayList<city> cities = app.getDistrictPopls();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayCityDistrict(cities);
    }

    @Test
    void getRegionPopls() throws SQLException {
        ArrayList<city> cities = app.getRegionPopls();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayRegion(cities);
    }

    @Test
    void getTopNPopCit() throws SQLException {
        ArrayList<city> cities = app.getTopNPopCit();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopNPopCity(cities);
    }

    @Test
    void getTopNPopCitWorld() throws SQLException {
        ArrayList<city> cities = app.getTopNPopCitWorld();
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopNPopCityWorld(cities);
    }

    @Test
    void getTopCityContinent() throws SQLException {
        ArrayList<city> cities = app.getTopCityContinent(10);
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopCityContinent(cities, 10);
    }

    @Test
    void getTopCityRegion() throws SQLException {
        ArrayList<city> cities = app.getTopCityRegion(10);
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopCityRegion(cities, 10);
    }

    @Test
    void getTopCityDistrict() throws SQLException {
        ArrayList<city> cities = app.getTopCityDistrict(10);
        assertNotNull(cities);
        assertEquals(cities.size() > 0, true);
        app.displayTopCityDistrict(cities, 10);
    }

    @Test
    void getCountryPopLsRegion() {
        ArrayList<country> countries = app.getCountryPopLsRegion();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCountryPopLSRegion(countries);
    }

    @Test
    void getCouCon() {
        ArrayList<country> countries = app.getCouCon();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCouCon(countries);
    }

    @Test
    void getCountryPopLs() {
        ArrayList<country> countries = app.getCountryPopLs();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCountry(countries);
    }


    @Test
    void getCountryTopPop() {
        ArrayList<country> countries = app.getCountryTopPop(10);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayTopCountryPop(countries, 10);
    }

    @Test
    void getTopCouContinent() {
        ArrayList<country> countries = app.getTopCouContinent(10);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayTopCouContPop(countries, 10);
    }

    @Test
    void getTopCouRegion() {
        ArrayList<country> countries = app.getTopCouRegion(10);
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayTopCouRegPop(countries, 10);
    }

    @Test
    void getCapitalPopls() throws SQLException {
        ArrayList<capitalCity> capCities = app.getCapitalPopls();
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayCapital(capCities);
    }

    @Test
    void getCapCityConLToS() throws SQLException {
        ArrayList<capitalCity> capCities = app.getCapCityConLToS();
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayCapCitCon(capCities);
    }

    @Test
    void getCapCitRegLS() throws SQLException {
        ArrayList<capitalCity> capCities = app.getCapCitRegLS();
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.dispalyCapCitRegLs(capCities);
    }

    @Test
    void getTCAWPopls() throws SQLException {
        ArrayList<capitalCity> capCities = app.getTCAWPopls(10);
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayTCAW(capCities, 10);
    }

    @Test
    void getTCACPopls() throws SQLException {
        ArrayList<capitalCity> capCities = app.getTCACPopls(10);
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayTCAC(capCities, 10);
    }

    @Test
    void getTCARPopls() throws SQLException {
        ArrayList<capitalCity> capCities = app.getTCARPopls(10);
        assertNotNull(capCities);
        assertEquals(capCities.size() > 0, true);
        app.displayTCAR(capCities, 10);
    }
}