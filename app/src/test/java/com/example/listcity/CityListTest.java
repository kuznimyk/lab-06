package com.example.listcity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity(){
        return new City("Edmonton", "AB");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCityRemoval() {
        CityList cityList = mockCityList();
        City city = mockCity();

        // Verify city is in the list initially
        assertEquals(1, cityList.countCities());
        assertTrue(cityList.getCities().contains(city));

        // Call hasCity and check if it returns true
        boolean result = cityList.hasCity(city);
        assertTrue(result);

        // Verify city was removed
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.getCities().contains(city));
    }

    @Test
    void testHasCityException() {
        CityList cityList = mockCityList();
        City nonExistentCity = new City("NonExistent", "NoProvince");

        // Verify exception is thrown for non-existent city
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.hasCity(nonExistentCity);
        });
    }

    @Test
    void testHasCityCountUpdate() {
        CityList cityList = new CityList();
        City city = mockCity();

        // Add city and verify count
        cityList.add(city);
        assertEquals(1, cityList.countCities());

        // Remove via hasCity and verify count updates
        cityList.hasCity(city);
        assertEquals(0, cityList.countCities());
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        cityList.add(mockCity());
        assertEquals(1, cityList.countCities());

        City secondCity = new City("Vancouver", "BC");
        cityList.add(secondCity);
        assertEquals(2, cityList.countCities());

        // Test count after removal
        cityList.hasCity(secondCity);
        assertEquals(1, cityList.countCities());
    }

}
