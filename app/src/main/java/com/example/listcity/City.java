package com.example.listcity;


/**
 * class that contains variables and methods of the city


 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * Constructs a new City with the specified name and province.
     *
     * @param city The name of the city
     * @param province The province where the city is located
     */


    /**
     * Constructor for City class.
     * @param city
     * @param province
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Getter for city name.
     * @return city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Getter for province name.
     * @return province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares this city with another city lexicographically by city name.
     *
     * @param that The city to compare with
     * @return A negative integer, zero, or a positive integer if this city
     *         is less than, equal to, or greater than the specified city
     */
    @Override
    public int compareTo(City that) {
        return this.city.compareTo(that.getCityName());
    }


    /**
     * Determines if this city is equal to another object.
     *
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City city = (City) obj;
        return this.city.equals(city.getCityName()) && this.province.equals(city.getProvinceName());
    }
    /**
     * Generates a hash code for this city.
     *
     * @return A hash code value for this city
     */
    @Override
    public int hashCode() {
        int result = this.city != null ? this.city.hashCode() : 0;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        return result;
    }
}
