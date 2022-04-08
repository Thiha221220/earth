package com.napier.earth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void displayCity() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Seoul", "South Korea","Seoul", 9981619);
        cities.add(cit);
        App.displayCity(cities,"cities.md");
    }

    @Test
    void displayCityContainsNull() {
        App.displayCity(null,"cities.md");
    }

    @Test
    void displayCitySize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Seoul", "South Korea","Seoul", 9981619);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCityObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayCity(cities,"cities.md");
    }

    @Test
    void displayTopNPopCity() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Rangoon (Yangon)", "Myanmar","Rangoon [Yangon]", 3361700);
        cities.add(cit);
        App.displayTopNPopCity(cities,"topcity.md");
    }

    @Test
    void displayTopNPopCityContainsNull() {
        App.displayTopNPopCity(null,"topcity.md");
    }

    @Test
    void displayTopNPopCitySize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Rangoon (Yangon)", "Myanmar","Rangoon [Yangon]", 3361700);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopNPopCityObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayTopNPopCity(cities,"topcity.md");
    }

    @Test
    void displayTopNPopCityWorld() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("New York", "United","New York", 8008278);
        cities.add(cit);
        App.displayTopNPopCityWorld(cities,"topcityworld.md");
    }

    @Test
    void displayTopNPopCityWorldContainNull() {
        App.displayTopNPopCityWorld(null,"topcityworld.md");
    }

    @Test
    void displayTopNPopCityWorldSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("New York", "United","New York", 8008278);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopNPopCityWorldObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayTopNPopCityWorld(cities,"topcityworld.md");
    }

    @Test
    void displayCityCountry() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("New York", "United","New York", 8008278);
        cities.add(cit);
        App.displayCityCountry(cities,"cityincountry.md");
    }

    @Test
    void displayCityCountryContainNull() {
        App.displayCityCountry(null,"cityincountry.md");
    }

    @Test
    void displayCityCountrySize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("New York", "United","New York", 8008278);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCityCountryObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayCityCountry(cities,"cityincountry.md");
    }

    @Test
    void displayCityDistrict() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("London", "United Kingdom","England", 7285000);
        cities.add(cit);
        App.displayCityDistrict(cities,"cityindistrict.md");
    }

    @Test
    void displayCityDistrictContainNull() {
        App.displayCityDistrict(null,"cityindistrict.md");
    }

    @Test
    void displayCityDistrictSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("London", "United Kingdom","England", 7285000);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCityDistrictObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayCityDistrict(cities,"cityindistrict.md");
    }

    @Test
    void displayCityContinent() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Roma", "Italy","Latium", 2643581);
        cities.add(cit);
        App.displayCityContinent(cities,"cityincontinent.md");
    }

    @Test
    void displayCityContinentContainNull() {
        App.displayCityContinent(null,"cityincontinent.md");
    }

    @Test
    void displayCityContinentSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Roma", "Italy","Latium", 2643581);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCityContinentObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayCityContinent(cities,"cityincontinent.md");
    }

    @Test
    void displayRegion() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Bangkok", "Thailand","Bangkok", 6320174);
        cities.add(cit);
        App.displayRegion(cities,"cityinregion.md");
    }

    @Test
    void displayRegionContainNull() {
        App.displayRegion(null,"cityinregion.md");
    }

    @Test
    void displayRegionSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Bangkok", "Thailand","Bangkok", 6320174);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayRegionObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayRegion(cities,"cityinregion.md");
    }

    @Test
    void displayTopCityContinent() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Shanghai", "China","Shanghai", 96963000);
        cities.add(cit);
        App.displayTopCityContinent(cities, 10,"topcityincontinent.md");
    }

    @Test
    void displayTopCityContinentContainNull() {

        App.displayTopCityContinent(null,10,"topcityincontinent.md");
    }

    @Test
    void displayTopCityContinentSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Shanghai", "China","Shanghai", 96963000);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopCityContinentObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayTopCityContinent(cities,10,"topcityincontinent.md");
    }

    @Test
    void displayTopCityRegion() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Jakarta", "Indonesia","Jakarta Raya", 9604900);
        cities.add(cit);
        App.displayTopCityRegion(cities, 10,"topcityinregion.md");
    }

    @Test
    void displayTopCityRegionContainNull() {
        App.displayTopCityRegion(null,10,"topcityinregion.md");
    }

    @Test
    void displayTopCityRegionSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Jakarta", "Indonesia","Jakarta Raya", 9604900);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopCityRegionObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayTopCityRegion(cities,10,"topcityinregion.md");
    }

    @Test
    void displayTopCityDistrict() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Leeds", "United Kingdom","England", 424194);
        cities.add(cit);
        App.displayTopCityDistrict(cities, 10,"topcityindistrict.md");
    }

    @Test
    void displayTopCityDistrictContainNull() {
        App.displayTopCityDistrict(null,10,"topcityindistrict.md");
    }

    @Test
    void displayTopCityDistrictSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City("Leeds", "United Kingdom","England", 424194);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopCityDistrictObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayTopCityDistrict(cities,10,"topcityindistrict.md");
    }

    @Test
    void displayCityPopulation() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City(339917);
        cities.add(cit);
        App.displayCityPopulation(cities,"citypopls.md");
    }

    @Test
    void displayCityPopulationContainNull() {
        App.displayCityPopulation(null,"citypopls.md");
    }

    @Test
    void displayCityPopulationSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City(339917);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCityPopulationObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayCityPopulation(cities,"citypopls.md");
    }

    @Test
    void displayPopdist() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City(16716706);
        cities.add(cit);
        App.displayPopdist(cities,"districtpopls.md");
    }

    @Test
    void displayPopdistContainNull() {
        App.displayPopdist(null,"districtpopls.md");
    }

    @Test
    void displayPopdistSize() {
        ArrayList<City> cities =  new ArrayList<City>();
        City cit = new City(339917);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayPopdistObjectNull() {
        ArrayList<City> cities =  new ArrayList<City>();
        cities.add(null);
        App.displayPopdist(cities,"districtpopls.md");
    }

    @Test
    void displayTCAW() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Leeds", "United Kingdom", 424194);
        cities.add(cit);
        App.displayTCAW(cities, 10,"topcapcityinworld.md");
    }

    @Test
    void displayTCAWContainNull() {
        App.displayTCAW(null,10,"topcapcityinworld.md");
    }

    @Test
    void displayTCAWSize() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Leeds", "United Kingdom", 424194);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTCAWObjectNull() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        cities.add(null);
        App.displayTCAW(cities,10,"topcapcityinworld.md");
    }

    @Test
    void displayTCAC() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Canberra", "Australia", 322723);
        cities.add(cit);
        App.displayTCAC(cities, 10,"topcapcityincontinent.md");
    }

    @Test
    void displayTCAContainNull() {
        App.displayTCAC(null,10,"topcapcityincontinent.md");
    }

    @Test
    void displayTCACSize() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Canberra", "Australia", 322723);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTCACObjectNull() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        cities.add(null);
        App.displayTCAC(cities,10,"topcapcityincontinent.md");
    }

    @Test
    void displayTCAR() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Baghdad", "Iraq", 4336000);
        cities.add(cit);
        App.displayTCAR(cities, 10,"topcapcityinregion.md");
    }

    @Test
    void displayTCARContainNull() {
        App.displayTCAR(null,10,"topcapcityinregion.md");
    }

    @Test
    void displayTCARSize() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Baghdad", "Iraq", 4336000);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTCARObjectNull() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        cities.add(null);
        App.displayTCAR(cities,10,"topcapcityinregion.md");
    }

    @Test
    void displayCountry() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("CHN","China", "Asia", "Eastern Asia", (long) Math.round(1.27755802E9), "Peking");
        coucons.add(cit);
        App.displayCountry(coucons,"countriesinworld.md");
    }

    @Test
    void displayCountryContainNull() {
        App.displayCountry(null,"countriesinworld.md");
    }

    @Test
    void displayCountrySize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("CHN","China", "Asia", "Eastern Asia", (long) Math.round(1.27755802E9), "Peking");
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCountryObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayCountry(cities,"countriesinworld.md");
    }

    @Test
    void displayCountryPopLSRegion() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("MMR","Myanmar", "Asia", "Southeast Asia", (long) Math.round(4.5611E7), "Rangoon (Yangon");
        coucons.add(cit);
        App.displayCountryPopLSRegion(coucons,"countryinregion.md");
    }

    @Test
    void displayCountryPopLSRegionContainNull() {
        App.displayCountryPopLSRegion(null,"countryinregion.md");
    }

    @Test
    void displayCountryPopLSRegionSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("MMR","Myanmar", "Asia", "Southeast Asia", (long) Math.round(4.5611E7), "Rangoon (Yangon");
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCountryPopLSRegionObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayCountryPopLSRegion(cities,"countryinregion.md");
    }

    @Test
    void displayCouCon() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("ITA","Italy", "Europe", "Southern Europe", (long) Math.round(5.768E7), "Roma");
        coucons.add(cit);
        App.displayCouCon(coucons,"countryincontinent.md");
    }

    @Test
    void displayCouConContainNull() {
        App.displayCouCon(null,"countryincontinent.md");
    }

    @Test
    void displayCouConSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("ITA","Italy", "Europe", "Southern Europe", (long) Math.round(5.768E7), "Roma");
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCouConObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayCouCon(cities,"countryincontinent.md");
    }

    @Test
    void displayTopCountryPop() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("JPN","Japan", "Eastern Asia", "Asia", (long) Math.round(1.26714E8), "Tokyo");
        coucons.add(cit);
        App.displayTopCountryPop(coucons, 10,"topcouinworld.md");
    }

    @Test
    void displayTopCountryPopContainNull() {
        App.displayTopCountryPop(null,10,"topcouinworld.md");
    }

    @Test
    void displayTopCountryPopSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("JPN","Japan", "Eastern Asia", "Asia", (long) Math.round(1.26714E8), "Tokyo");
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopCountryPopObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayTopCountryPop(cities,10,"topcouinworld.md");
    }

    @Test
    void displayTopCouContPop() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("CAN","Canada", "North America", "North America", (long) Math.round(3.1147E7), "Ottawa");
        coucons.add(cit);
        App.displayTopCouContPop(coucons, 10,"topcouincontinent.md");
    }

    @Test
    void displayTopCouContContainNull() {
        App.displayTopCouContPop(null,10,"topcouincontinent.md");
    }

    @Test
    void displayTopCouContSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("CAN","Canada", "North America", "North America", (long) Math.round(3.1147E7), "Ottawa");
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopCouConObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayTopCouContPop(cities,10,"topcouincontinent.md");
    }

    @Test
    void displayTopCouRegPop() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("BRB","Barbadoas", "North America", "Caribbean", (long)270000, "Bridgetown");
        coucons.add(cit);
        App.displayTopCouRegPop(coucons, 10,"topcouinregion.md");
    }

    @Test
    void displayTopCouRegContainNull() {
        App.displayTopCouRegPop(null,10,"topcouinregion.md");
    }

    @Test
    void displayTopCouRegSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("BRB","Barbadoas", "North America", "Caribbean", (long)270000, "Bridgetown");
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayTopCouRegObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayTopCouRegPop(cities,10,"topcouinregion.md");
    }

    @Test
    void displayPopW() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country(Long.parseLong("6078749450"));
        coucons.add(cit);
        App.displayPopW(coucons, "worldpopls.md");
    }

    @Test
    void displayPopWContainNull() {
        App.displayPopW(null,"worldpopls.md");
    }

    @Test
    void displayPopWSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country(Long.parseLong("6078749450"));
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayPopWObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayPopW(cities,"worldpopls.md");
    }

    @Test
    void displayPopE() throws SQLException {
        ArrayList<Country> popw = new ArrayList<Country>();
        ArrayList<Country> pope = new ArrayList<Country>();
        ArrayList<Country> popc = new ArrayList<Country>();
        ArrayList<Country> popa = new ArrayList<Country>();
        ArrayList<Country> poph = new ArrayList<Country>();
        ArrayList<Country> pops = new ArrayList<Country>();
        Country cit = new Country(Long.parseLong("6078749450"));
        popw.add(cit);
        Country cit1 = new Country((long)459158800);
        pope.add(cit1);
        Country cit2 = new Country((long)1281125000);
        popc.add(cit2);
        Country cit3 = new Country((long)293364000);
        poph.add(cit3);
        Country cit4 = new Country((long)1013662000);
        popa.add(cit4);
        Country cit5 = new Country((long)372190700);
        pops.add(cit5);
        ArrayList<Country>[] coucons = new ArrayList[]{popw, pope, popc, popa, poph, pops};
        App.displayPopE(coucons, "languagepopls.md");
    }

    @Test
    void displayPopEContainNull() throws SQLException {
        App.displayPopE(null,"languagepopls.md");
    }

    @Test
    void displayPopESize() {
        ArrayList<Country> popw = new ArrayList<Country>();
        ArrayList<Country> pope = new ArrayList<Country>();
        ArrayList<Country> popc = new ArrayList<Country>();
        ArrayList<Country> popa = new ArrayList<Country>();
        ArrayList<Country> poph = new ArrayList<Country>();
        ArrayList<Country> pops = new ArrayList<Country>();
        Country cit = new Country(Long.parseLong("6078749450"));
        popw.add(cit);
        Country cit1 = new Country((long)459158800);
        pope.add(cit1);
        Country cit2 = new Country((long)1281125000);
        popc.add(cit2);
        Country cit3 = new Country((long)293364000);
        poph.add(cit3);
        Country cit4 = new Country((long)1013662000);
        popa.add(cit4);
        Country cit5 = new Country((long)372190700);
        pops.add(cit5);
        ArrayList<Country>[] coucons = new ArrayList[]{popw, pope, popc, popa, poph, pops};
        assertEquals(6,coucons.length);
    }

    @Test
    void displayPopReg() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country((long)38140000);
        coucons.add(cit);
        App.displayPopReg(coucons, "regionpopls.md");
    }

    @Test
    void displayPopRegContainNull() {
        App.displayPopReg(null,"regionpopls.md");
    }

    @Test
    void displayPopRegSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country((long)38140000);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayPopRegObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayPopReg(cities,"regionpopls.md");
    }

    @Test
    void displayCntCitynotCity() {
        ArrayList<Population> coucons =  new ArrayList<Population>();
        Population cit = new Population("Afghanistan",22720000,2332100,20387900);
        coucons.add(cit);
        App.displayCntCitynotCity(coucons, "pplincountry.md");
    }

    @Test
    void displayCntCitynotCityContainNull() {
        App.displayCntCitynotCity(null,"pplincountry.md");
    }

    @Test
    void displayCntCitynotCitySize() {
        ArrayList<Population> cities =  new ArrayList<Population>();
        Population cit = new Population("Afghanistan",22720000,2332100,20387900);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCntCitynotCityObjectNull() {
        ArrayList<Population> cities =  new ArrayList<Population>();
        cities.add(null);
        App.displayCntCitynotCity(cities,"pplincountry.md");
    }

    @Test
    void displayPopcon() {
        ArrayList<Population> coucons =  new ArrayList<Population>();
        Population cit = new Population("Asia",Long.parseLong("15112799830300"), Long.parseLong("72907554084"), Long.parseLong("15039892276216"));
        coucons.add(cit);
        App.displayPopcon(coucons,"pplincontinent.md");
    }

    @Test
    void displayPopconContainNull() {
        App.displayPopcon(null,"pplincontinent.md");
    }

    @Test
    void displayPopconSize() {
        ArrayList<Population> cities =  new ArrayList<Population>();
        Population cit = new Population("Asia",Long.parseLong("15112799830300"), Long.parseLong("72907554084"), Long.parseLong("15039892276216"));
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayPopconObjectNull() {
        ArrayList<Population> cities =  new ArrayList<Population>();
        cities.add(null);
        App.displayPopcon(cities,"pplincontinent.md");
    }
    @Test
    void displayPepPopReg() {
        ArrayList<Population> coucons =  new ArrayList<Population>();
        Population cit = new Population("Central America",Long.parseLong("17245853000"), Long.parseLong("65860964"), Long.parseLong("17179992036"));
        coucons.add(cit);
        App.displayPepPopReg(coucons,"pplinregion.md");
    }

    @Test
    void displayPepPopRegContainNull() {
        App.displayPepPopReg(null,"pplinregion.md");
    }

    @Test
    void displayPepPopRegSize() {
        ArrayList<Population> cities =  new ArrayList<Population>();
        Population cit = new Population("Central America",Long.parseLong("17245853000"), Long.parseLong("65860964"), Long.parseLong("17179992036"));
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayPepPopRegObjectNull() {
        ArrayList<Population> cities =  new ArrayList<Population>();
        cities.add(null);
        App.displayPepPopReg(cities,"pplinregion.md");
    }

    @Test
    void displayCountryPopulation() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country((long)45611000);
        coucons.add(cit);
        App.displayCountryPopulation(coucons,"countrypopls.md");
    }

    @Test
    void displayCountryPopulationNull() {
        App.displayCountryPopulation(null,"countrypopls.md");
    }

    @Test
    void displayCountryPopulationSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country((long)45611000);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCountryPopulationObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayCountryPopulation(cities,"countrypopls.md");
    }

    @Test
    void displayPopcont() {
        ArrayList<Country> coucons =  new ArrayList<Country>();
        Country cit = new Country("Asia",Long.parseLong("3705025700"));
        coucons.add(cit);
        App.displayPopcont(coucons,"continentpopls.md");
    }

    @Test
    void displayPopcontContainNull() {
        App.displayPopcont(null,"continentpopls.md");
    }

    @Test
    void displayPopcontSize() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        Country cit = new Country("Asia",Long.parseLong("3705025700"));
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayPopcontObjectNull() {
        ArrayList<Country> cities =  new ArrayList<Country>();
        cities.add(null);
        App.displayPopcont(cities,"continentpopls.md");
    }

    @Test
    void displayCapital() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Lina", "Peru", 6464693);
        cities.add(cit);
        App.displayCapital(cities,"capcityinworld.md");

    }

    @Test
    void displayCapitalContainNull() {
        App.displayCapital(null,"capcityinworld.md");
    }

    @Test
    void displayCapitalSize() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("Lina", "Peru", 6464693);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCapitalObjectNull() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        cities.add(null);
        App.displayCapital(cities,"capcityinworld.md");
    }

    @Test
    void dispalyCapCitRegLs() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("La Habana", "Cuba", 2256000);
        cities.add(cit);
        App.dispalyCapCitRegLs(cities,"capcityinregion.md");
    }

    @Test
    void displayCapCitRegLsContainNull() {
        App.dispalyCapCitRegLs(null,"capcityinregion.md");
    }

    @Test
    void displayCapCitRegLsSize() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("La Habana", "Cuba", 2256000);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCapCitRegLsObjectNull() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        cities.add(null);
        App.dispalyCapCitRegLs(cities,"capcityinregion.md");
    }

    @Test
    void displayCapCitCon() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("New York", "United States", 8008278);
        cities.add(cit);
        App.dispalyCapCitRegLs(cities,"capcityincontinent.md");
    }

    @Test
    void displayCapCitConContainNull() {
        App.dispalyCapCitRegLs(null,"capcityincontinent.md");
    }

    @Test
    void displayCapCitConSize() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        CapitalCity cit = new CapitalCity("New York", "United States", 8008278);
        cities.add(cit);
        assertEquals(1,cities.size());
    }

    @Test
    void displayCapCitConObjectNull() {
        ArrayList<CapitalCity> cities =  new ArrayList<CapitalCity>();
        cities.add(null);
        App.dispalyCapCitRegLs(cities,"capcityincontinent.md");
    }

}