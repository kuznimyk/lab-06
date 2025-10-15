package com.example.listcity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that manages a list of cities, allowing addition, retrieval, counting, and checking/removal of cities.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * Adds a city to the list if it doesn't already exist.
     *
     * @param city The city to add
     * @throws IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (cities.contains(city)){
            throw new IllegalArgumentException("City already exists in the list");
        }
        cities.add(city);
    }



    /**
     * Returns the list of cities.
     *
     * @return The list of cities
     */
    public List<City> getCities(){
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }



    /**
     * Returns the number of cities in the list.
     *
     * @return The count of cities
     */
    public int countCities(){
        return cities.size();
    }

    /**
     * Checks if a city is in the list, removes it if found, throws exception if not found.
     *
     * @param city The city to check and potentially remove
     * @return true if the city was found and removed
     * @throws IllegalArgumentException if the city is not in the list
     */

    public boolean hasCity(City city){
        for (City c: cities){
            if (c.equals(city)){
                cities.remove(c);
                return true;
            }
        }
        throw new IllegalArgumentException("City is not in the list");
    }




}
