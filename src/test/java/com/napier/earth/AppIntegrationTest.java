package com.napier.earth;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        App.connect("localhost:33060", 30000);

    }

    @Test
    void getCityPopLs() {
        ArrayList<City> cities = App.getCityPopLs();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayCity(cities, "cities.md");
        City cp = null;

        for (City c : cities) {
            if (c.getName().equals("Mumbai (Bombay)")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(10500000, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCityCountryPopLs() throws SQLException {
        ArrayList<City> cities = app.getCityCountryPopLs();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayCityCountry(cities, "cityincountry.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Seoul")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(9981619, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCityContinentPopLs() throws SQLException {
        ArrayList<City> cities = app.getCityContinentPopLs();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayCityContinent(cities, "cityincontinent.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Moscow")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(8389200, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getDistrictPopls() {
        ArrayList<City> cities = app.getDistrictPopls();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayCityDistrict(cities, "cityindistrict.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("London")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(7285000, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getRegionPopls() throws SQLException {
        ArrayList<City> cities = app.getRegionPopls();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayRegion(cities, "cityinregion.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Jakarta")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(9604900, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopNPopCit() throws SQLException {
        ArrayList<City> cities = app.getTopNPopCit();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayTopNPopCity(cities, "topcity.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Rangoon (Yangon)")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(3361700, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopNPopCitWorld() throws SQLException {
        ArrayList<City> cities = app.getTopNPopCitWorld();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayTopNPopCityWorld(cities, "topcityworld.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Seoul")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(9981619, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopCityContinent() {
        ArrayList<City> cities = app.getTopCityContinent(10);
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayTopCityContinent(cities, 10, "topcityincontinent.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Shanghai")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(9696300, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopCityRegion() throws SQLException {
        ArrayList<City> cities = app.getTopCityRegion(10);
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayTopCityRegion(cities, 10, "topcityinregion");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Bangkok")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(6320174, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopCityDistrict() {
        ArrayList<City> cities = app.getTopCityDistrict(10);
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayTopCityDistrict(cities, 10, "topcityindistrict.md");

        City cp = null;
        for (City c : cities) {
            if (c.getName().equals("Birmingham")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(1013000, Objects.requireNonNull(cp).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCountryPopLsRegion() {
        ArrayList<Country> countries = app.getCountryPopLsRegion();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayCountryPopLSRegion(countries, "countryinregion.md");

        Country cou = null;
        for (Country c : countries) {
            if (c.getName().equals("Indonesia")) {
                cou = c;
                break;
            }
        }
        Assertions.assertEquals(212107000, Objects.requireNonNull(cou).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCouCon() {
        ArrayList<Country> countries = app.getCouCon();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayCouCon(countries, "countryincontinent.md");

        Country cou = null;
        for (Country c : countries) {
            if (c.getName().equals("Germany")) {
                cou = c;
                break;
            }
        }
        Assertions.assertEquals(82164700, Objects.requireNonNull(cou).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCountryPopLs() {
        ArrayList<Country> countries = app.getCountryPopLs();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayCountry(countries, "countriesinworld.md");

        Country cou = null;
        for (Country c : countries) {
            if (c.getName().equals("China")) {
                cou = c;
                break;
            }
        }
        Assertions.assertEquals(1277558000, Objects.requireNonNull(cou).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");

    }


    @Test
    void getCountryTopPop() {
        ArrayList<Country> countries = app.getCountryTopPop(10);
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayTopCountryPop(countries, 10, "topcouinworld.md");

        Country cou = null;
        for (Country c : countries) {
            if (c.getName().equals("India")) {
                cou = c;
                break;
            }
        }
        Assertions.assertEquals(1013662000, Objects.requireNonNull(cou).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopCouContinent() {
        ArrayList<Country> countries = app.getTopCouContinent(10);
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayTopCouContPop(countries, 10, "topcouincontinent.md");

        Country cou = null;
        for (Country c : countries) {
            if (c.getName().equals("United States")) {
                cou = c;
                break;
            }
        }
        Assertions.assertEquals(278357000, Objects.requireNonNull(cou).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTopCouRegion() {
        ArrayList<Country> countries = app.getTopCouRegion(10);
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayTopCouRegPop(countries, 10, "topcouinregion.md");

        Country cou = null;
        for (Country c : countries) {
            if (c.getName().equals("Cuba")) {
                cou = c;
                break;
            }
        }
        Assertions.assertEquals(11201000, Objects.requireNonNull(cou).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCapitalPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getCapitalPopls();
        assertNotNull(capCities);
        assertTrue(capCities.size() > 0);
        App.displayCapital(capCities, "capcityinworld.md");

        CapitalCity cap = null;
        for (CapitalCity c : capCities) {
            if (c.getName().equals("Seoul")) {
                cap = c;
                break;
            }
        }
        Assertions.assertEquals(9981619, Objects.requireNonNull(cap).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCapCityConLToS() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getCapCityConLToS();
        assertNotNull(capCities);
        assertTrue(capCities.size() > 0);
        app.displayCapCitCon(capCities, "capcityincontinent.md");

        CapitalCity cap = null;
        for (CapitalCity c : capCities) {
            if (c.getName().equals("New York")) {
                cap = c;
                break;
            }
        }
        Assertions.assertEquals(8008278, Objects.requireNonNull(cap).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCapCitRegLS() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getCapCitRegLS();
        assertNotNull(capCities);
        assertTrue(capCities.size() > 0);
        App.dispalyCapCitRegLs(capCities, "capcityinregion.md");

        CapitalCity cap = null;
        for (CapitalCity c : capCities) {
            if (c.getName().equals("La Habana")) {
                cap = c;
                break;
            }
        }
        Assertions.assertEquals(2256000, Objects.requireNonNull(cap).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTCAWPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getTCAWPopls(10);
        assertNotNull(capCities);
        assertTrue(capCities.size() > 0);
        App.displayTCAW(capCities, 10, "topcapcityinworld.md");

        CapitalCity cap = null;
        for (CapitalCity c : capCities) {
            if (c.getName().equals("Tokyo")) {
                cap = c;
                break;
            }
        }
        Assertions.assertEquals(7980230, Objects.requireNonNull(cap).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTCACPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getTCACPopls(10);
        assertNotNull(capCities);
        assertTrue(capCities.size() > 0);
        App.displayTCAC(capCities, 10, "topcapcityincontinent.md");

        CapitalCity cap = null;
        for (CapitalCity c : capCities) {
            if (c.getName().equals("Canberra")) {
                cap = c;
                break;
            }
        }
        Assertions.assertEquals(322723, Objects.requireNonNull(cap).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getTCARPopls() throws SQLException {
        ArrayList<CapitalCity> capCities = app.getTCARPopls(10);
        assertNotNull(capCities);
        assertTrue(capCities.size() > 0);
        App.displayTCAR(capCities, 10, "topcapcityinregion.md");

        CapitalCity cap = null;
        for (CapitalCity c : capCities) {
            if (c.getName().equals("Baghdad")) {
                cap = c;
                break;
            }
        }
        Assertions.assertEquals(4336000, Objects.requireNonNull(cap).getPopulation(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getPopReg() throws SQLException {
        ArrayList<Country> countries = App.getPopReg();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayPopReg(countries, "regionpopls.md");

        long sum = 0;
        for (Country c : countries) {
            if (c == null)
                continue;
            sum += c.getPopulation();
        }

        Assertions.assertEquals(Long.parseLong("38140000"), sum, "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getPepPogReg() throws SQLException {
        ArrayList<Population> Cities = App.getPepPogReg();
        assertNotNull(Cities);
        assertTrue(Cities.size() > 0);
        App.displayPepPopReg(Cities, "pplinregion.md");

        Population cp = null;
        for (Population c : Cities) {
            if (c.getName().equals("Australia and New Zealand")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(299167700, Objects.requireNonNull(cp).getTotal(), "The value are not equals!");
        System.out.println("The value are equals.");
    }
    @Test
    void getPopdist() throws SQLException {
        ArrayList<City> cities = App.getPopdist();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayPopdist(cities, "districtpopls.md");

        long sum = 0;
        for (City c: cities){
            if (c == null)
                continue;
            sum += c.getPopulation();
        }
        Assertions.assertEquals(16716706, sum, "The value are not equals!");
        System.out.println("The value are equals.");
    }
    @Test
    void getPopcon() throws SQLException {
        ArrayList<Population> Cities = App.getPopcon();
        assertNotNull(Cities);
        assertTrue(Cities.size() > 0);
        App.displayPopcon(Cities, "pplincontinent.md");

        Population cp = null;
        for (Population c : Cities) {
            if (c.getName().equals("Asia")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(Long.parseLong("15112799830300"), Objects.requireNonNull(cp).getTotal(), "The value are not equals!");
        System.out.println("The value are equals.");
    }
    @Test
    void getPopcont() throws SQLException {
        ArrayList<Country> countries = App.getPopcont();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayPopcont(countries, "continentpopls.md");

        long sum = 0;
        for (Country c: countries){
            if (c == null)
                continue;
            sum += c.getPopulation();
        }
        Assertions.assertEquals(Long.parseLong("3705025700"), sum, "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCntCitynotCity(){
        ArrayList<Population> Cities = App.getCntCitynotCity();
        assertNotNull(Cities);
        assertTrue(Cities.size() > 0);
        App.displayCntCitynotCity(Cities, "pplincountry.md");

        Population cp = null;
        for (Population c : Cities) {
            if (c.getName().equals("Afghanistan")) {
                cp = c;
                break;
            }
        }
        Assertions.assertEquals(22720000, Objects.requireNonNull(cp).getTotal(), "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCityPopulation() {
        ArrayList<City> cities = App.getCityPopulation();
        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        App.displayPopdist(cities, "citypopls.md");

        long sum = 0;
        for (City c: cities){
            if (c == null)
                continue;
            sum += c.getPopulation();
        }
        Assertions.assertEquals(7624917, sum, "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getCountryPopulation(){
        ArrayList<Country> countries = App.getCountryPopulation();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayCountryPopulation(countries, "countrypopls.md");

        long sum = 0;
        for (Country c: countries){
            if (c == null)
                continue;
            sum += c.getPopulation();
        }
        Assertions.assertEquals(45611000, sum, "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getPopsW() throws SQLException {
        ArrayList<Country> countries = App.getPopsW();
        assertNotNull(countries);
        assertTrue(countries.size() > 0);
        App.displayPopW(countries, "worldpopls.md");
        long sum = 0;
        for (Country c : countries) {
            if (c == null)
                continue;
            sum += c.getPopulation();
        }

        Assertions.assertEquals(Long.parseLong("6078749450"), sum, "The value are not equals!");
        System.out.println("The value are equals.");
    }

    @Test
    void getLanguagePops() throws SQLException {
        ArrayList<Country>[] countries = App.getLanguagePops();
        assertNotNull(countries);
        assertTrue(countries.length > 0);
        App.displayPopE(countries, "languagepopls.md");
    }
}
