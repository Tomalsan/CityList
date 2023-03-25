package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public void delete(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }
   public int Count()
   {
       return cities.size();
   }
    public class sortByProvince implements Comparator<City> {
        @Override
        public int compare(City o1, City o2) {
            return o1.getProvinceName().compareTo(o2.getProvinceName());
        }
    }
    public List<City> getCities(int sel) {
        List<City> cityList = cities;
        if(sel==0)
        {
            Collections.sort(cityList);
        }

        else
        {
            Collections.sort(cityList, new sortByProvince() );
        }

        return cityList;
    }
}
