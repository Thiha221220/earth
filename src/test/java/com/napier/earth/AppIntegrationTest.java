package com.napier.earth;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

//    @Test
//    void getCityPopLs() {
//
//    }
//
//
//
//    @Test
//    void getCityCountryPopLs() {
//    }
//
//    @Test
//    void getCityContinentPopLs() {
//    }
//
//    @Test
//    void getDistrictPopls() {
//    }
//
//    @Test
//    void getRegionPopls() {
//    }
//
//    @Test
//    void getTopNPopCit() {
//    }
//
//    @Test
//    void getTopNPopCitWorld() {
//    }
//
//    @Test
//    void getTopCityContinent() {
//    }
//
//    @Test
//    void getTopCityRegion() {
//    }
//
//    @Test
//    void getTopCityDistrict() {
//    }
//
//    @Test
//    void getCountryPopLsRegion() {
//    }
//
//    @Test
//    void getCouCon() {
//    }

    @Test
    void getCountryPopLs() {
        ArrayList<country> countries = app.getCountryPopLs();
        assertNotNull(countries);
        assertEquals(countries.size() > 0, true);
        app.displayCountry(countries);
    }

//
//    @Test
//    void getCountryTopPop() {
//    }
//
//    @Test
//    void getTopCouContinent() {
//    }
//
//    @Test
//    void getTopCouRegion() {
//    }
//
//    @Test
//    void getCapitalPopls() {
//    }
//
//    @Test
//    void getCapCityConLToS() {
//    }
//
//    @Test
//    void getCapCitRegLS() {
//    }
//
//    @Test
//    void getTCAWPopls() {
//    }
//
//    @Test
//    void getTCACPopls() {
//    }
//
//    @Test
//    void getTCARPopls() {
//    }
}