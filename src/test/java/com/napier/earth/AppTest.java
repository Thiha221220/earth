//package com.napier.earth;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeAll;
//
//import java.util.ArrayList;
//
//
//public class AppTest {
//    static App app;
//
//    @BeforeAll
//    static void init()
//    {
//        app = new App();
//    }
//
//    @Test
//    void displayCity() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Seoul", "South Korea","Seoul", 9981619);
//        cities.add(cit);
//        App.displayCity(cities);
//    }
//
//    @Test
//    void displayTopNPopCity() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Rangoon (Yangon)", "Myanmar","Rangoon [Yangon]", 3361700);
//        cities.add(cit);
//        App.displayTopNPopCity(cities);
//    }
//    @Test
//    void displayTopNPopCityWorld() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("New York", "United","New York", 8008278);
//        cities.add(cit);
//        App.displayTopNPopCityWorld(cities);
//    }
//
//    @Test
//    void displayCityCountry() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("New York", "United","New York", 8008278);
//        cities.add(cit);
//        App.displayCityCountry(cities);
//    }
//
//    @Test
//    void displayCityDistrict() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("London", "United Kingdom","England", 7285000);
//        cities.add(cit);
//        App.displayCityDistrict(cities);
//    }
//
//    @Test
//    void displayCityContinent() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Roma", "Italy","Latium", 2643581);
//        cities.add(cit);
//        App.displayCityContinent(cities);
//    }
//
//    @Test
//    void displayRegion() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Bangkok", "Thailand","Bangkok", 6320174);
//        cities.add(cit);
//        App.displayRegion(cities);
//    }
//
//    @Test
//    void displayTopCityContinent() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Shanghai", "China","Shanghai", 96963000);
//        cities.add(cit);
//        App.displayTopCityContinent(cities, 10);
//    }
//
//    @Test
//    void displayTopCityRegion() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Jakarta", "Indonesia","Jakarta Raya", 9604900);
//        cities.add(cit);
//        App.displayTopCityRegion(cities, 10);
//    }
//
//    @Test
//    void displayTopCityDistrict() {
//        ArrayList<City> cities =  new ArrayList<City>();
//        City cit = new City("Leeds", "United Kingdom","England", 424194);
//        cities.add(cit);
//        App.displayTopCityDistrict(cities, 10);
//    }
//
//    @Test
//    void displayTCAW() {
//        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
//        CapitalCity cit = new CapitalCity("Leeds", "United Kingdom", 424194);
//        cities.add(cit);
//        App.displayTCAW(cities, 10);
//    }
//
//    @Test
//    void displayTCAC() {
//        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
//        CapitalCity cit = new CapitalCity("Canberra", "Australia", 322723);
//        cities.add(cit);
//        App.displayTCAW(cities, 10);
//    }
//
//    @Test
//    void displayTCAR() {
//        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
//        CapitalCity cit = new CapitalCity("Baghdad", "Iraq", 4336000);
//        cities.add(cit);
//        App.displayTCAR(cities, 10);
//    }
//
//    @Test
//    void displayCountry() {
//        ArrayList<Country> coucons =  new ArrayList<Country>();
//        Country cit = new Country("CHN","China", "Asia", "Eastern Asia", (int) Math.round(1.27755802E9), "Peking");
//        coucons.add(cit);
//        App.displayCountry(coucons);
//    }
//
//    @Test
//    void displayCountryPopLSRegion() {
//        ArrayList<Country> coucons =  new ArrayList<Country>();
//        Country cit = new Country("MMR","Myanmar", "Asia", "Southeast Asia", (int) Math.round(4.5611E7), "Rangoon (Yangon");
//        coucons.add(cit);
//        App.displayCountryPopLSRegion(coucons);
//    }
//
//    @Test
//    void displayCouCon() {
//        ArrayList<Country> coucons =  new ArrayList<Country>();
//        Country cit = new Country("ITA","Italy", "Europe", "Southern Europe", (int) Math.round(5.768E7), "Roma");
//        coucons.add(cit);
//        App.displayCouCon(coucons);
//    }
//
//    @Test
//    void displayTopCountryPop() {
//        ArrayList<Country> coucons =  new ArrayList<Country>();
//        Country cit = new Country("JPN","Japan", "Eastern Asia", "Asia", (int) Math.round(1.26714E8), "Tokyo");
//        coucons.add(cit);
//        App.displayTopCountryPop(coucons, 10);
//    }
//
//    @Test
//    void displayTopCouContPop() {
//        ArrayList<Country> coucons =  new ArrayList<Country>();
//        Country cit = new Country("CAN","Canada", "North America", "North America", (int) Math.round(3.1147E7), "Ottawa");
//        coucons.add(cit);
//        App.displayTopCouContPop(coucons, 10);
//    }
//
//    @Test
//    void displayTopCouRegPop() {
//        ArrayList<Country> coucons =  new ArrayList<Country>();
//        Country cit = new Country("BRB","Barbadoas", "North America", "Caribbean", 270000, "Bridgetown");
//        coucons.add(cit);
//        App.displayTopCouRegPop(coucons, 10);
//    }
//
//    @Test
//    void displayCapital() {
//        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
//        CapitalCity cit = new CapitalCity("Lina", "Peru", 6464693);
//        cities.add(cit);
//        App.displayCapital(cities);
//
//    }
//
//    @Test
//    void dispalyCapCitRegLs() {
//        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
//        CapitalCity cit = new CapitalCity("La Habana", "Cuba", 2256000);
//        cities.add(cit);
//        App.dispalyCapCitRegLs(cities);
//    }
//
//    @Test
//    void displayCapCitCon() {
//        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
//        CapitalCity cit = new CapitalCity("New York", "United States", 8008278);
//        cities.add(cit);
//        App.dispalyCapCitRegLs(cities);
//    }
//
//}