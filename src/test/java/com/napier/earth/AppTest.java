package com.napier.earth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class AppTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayCity() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Seoul", "South Korea","Seoul", 9981619F);
        cities.add(cit);
        App.displayCity(cities);
    }

    @Test
    void displayTopNPopCity() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Rangoon (Yangon)", "Myanmar","Rangoon [Yangon]", 3361700.0F);
        cities.add(cit);
        App.displayTopNPopCity(cities);
    }
    @Test
    void displayTopNPopCityWorld() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("New York", "United","New York", 8008278.0F);
        cities.add(cit);
        App.displayTopNPopCityWorld(cities);
    }

    @Test
    void displayCityCountry() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("New York", "United","New York", 8008278.0F);
        cities.add(cit);
        App.displayCityCountry(cities);
    }

    @Test
    void displayCityDistrict() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("London", "United Kingdom","England", 7285000.0F);
        cities.add(cit);
        App.displayCityDistrict(cities);
    }

    @Test
    void displayCityContinent() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Roma", "Italy","Latium", 2643581.0F);
        cities.add(cit);
        App.displayCityContinent(cities);
    }

    @Test
    void displayRegion() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Bangkok", "Thailand","Bangkok", 6320174.0F);
        cities.add(cit);
        App.displayRegion(cities);
    }

    @Test
    void displayTopCityContinent() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Shanghai", "China","Shanghai", 96963000.0F);
        cities.add(cit);
        App.displayTopCityContinent(cities, 10);
    }

    @Test
    void displayTopCityRegion() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Jakarta", "Indonesia","Jakarta Raya", 9604900.0F);
        cities.add(cit);
        App.displayTopCityRegion(cities, 10);
    }

    @Test
    void displayTopCityDistrict() {
        ArrayList<city> cities =  new ArrayList<city>();
        city cit = new city("Leeds", "United Kingdom","England", 424194.0F);
        cities.add(cit);
        App.displayTopCityDistrict(cities, 10);
    }

    @Test
    void displayTCAW() {
        ArrayList<capitalCity> cities =  new ArrayList<capitalCity>();
        capitalCity cit = new capitalCity("Leeds", "United Kingdom", 424194.0F);
        cities.add(cit);
        App.displayTCAW(cities, 10);
    }

    @Test
    void displayTCAC() {
        ArrayList<capitalCity> cities =  new ArrayList<capitalCity>();
        capitalCity cit = new capitalCity("Canberra", "Australia", 322723.0F);
        cities.add(cit);
        App.displayTCAW(cities, 10);
    }

    @Test
    void displayTCAR() {
        ArrayList<capitalCity> cities =  new ArrayList<capitalCity>();
        capitalCity cit = new capitalCity("Baghdad", "Iraq", 4336000F);
        cities.add(cit);
        App.displayTCAR(cities, 10);
    }

    @Test
    void displayCountry() {
        ArrayList<country> coucons =  new ArrayList<country>();
        country cit = new country("CHN","China", "Asia", "Eastern Asia", (float) 1.27755802E9, "Peking");
        coucons.add(cit);
        App.displayCountry(coucons);
    }

    @Test
    void displayCountryPopLSRegion() {
        ArrayList<country> coucons =  new ArrayList<country>();
        country cit = new country("MMR","Myanmar", "Asia", "Southeast Asia", 4.5611E7F, "Rangoon (Yangon");
        coucons.add(cit);
        App.displayCountryPopLSRegion(coucons);
    }

    @Test
    void displayCouCon() {
        ArrayList<country> coucons =  new ArrayList<country>();
        country cit = new country("ITA","Italy", "Europe", "Southern Europe", 5.768E7F, "Roma");
        coucons.add(cit);
        App.displayCouCon(coucons);
    }

    @Test
    void displayTopCountryPop() {
        ArrayList<country> coucons =  new ArrayList<country>();
        country cit = new country("JPN","Japan", "", "Asia", 1.26714E8F, "Tokyo");
        coucons.add(cit);
        App.displayTopCountryPop(coucons, 10);
    }

    @Test
    void displayTopCouContPop() {
        ArrayList<country> coucons =  new ArrayList<country>();
        country cit = new country("CAN","Canada", "North America", "North America", 3.1147E7F, "Ottawa");
        coucons.add(cit);
        App.displayTopCouContPop(coucons, 10);
    }

    @Test
    void displayTopCouRegPop() {
        ArrayList<country> coucons =  new ArrayList<country>();
        country cit = new country("BRB","Barbadoas", "North America", "Caribbean", 270000F, "Bridgetown");
        coucons.add(cit);
        App.displayTopCouRegPop(coucons, 10);
    }

    @Test
    void displayCapital() {
        ArrayList<capitalCity> cities =  new ArrayList<capitalCity>();
        capitalCity cit = new capitalCity("Lina", "Peru", 6464693F);
        cities.add(cit);
        App.displayCapital(cities);

    }

    @Test
    void dispalyCapCitRegLs() {
        ArrayList<capitalCity> cities =  new ArrayList<capitalCity>();
        capitalCity cit = new capitalCity("La Habana", "Cuba", 2256000.0F);
        cities.add(cit);
        App.dispalyCapCitRegLs(cities);
    }

    @Test
    void displayCapCitCon() {
        ArrayList<capitalCity> cities =  new ArrayList<capitalCity>();
        capitalCity cit = new capitalCity("New York", "United States", 8008278.0F);
        cities.add(cit);
        App.dispalyCapCitRegLs(cities);
    }

}