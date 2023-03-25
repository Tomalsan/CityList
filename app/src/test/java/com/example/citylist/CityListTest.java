package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(0).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public  void testCount(){
        CityList cityList = new CityList();
        City city=new City("Gulisthan","Dhaka");
        cityList.add(new City("Jessore","Khulna"));
        cityList.add(city);
        assertEquals(2,cityList.Count());
        cityList.delete(city);
        assertEquals(1,cityList.Count());

    }

    @Test
    public void testdelete()
    {
        CityList cityList=new CityList();
        City city=new City("Gulisthan","Dhaka");
        cityList.add(city);
        cityList.add(new City("Jessore","Khulna"));
        assertEquals(2,cityList.Count());
        cityList.delete(city);
        assertEquals(1,cityList.Count());

    }
    @Test
    public void testdeleteexception(){
        CityList cityList=new CityList();
        City city=new City("Gulisthan","Dhaka");
        cityList.add(new City("Jessore","Khulna"));

        assertThrows(IllegalArgumentException.class,()->{
            cityList.delete(city);
        });

    }
    @Test
    public void testsort() {
        CityList cityList=new CityList();
        City city = new City("Gulisthan", "Dhaka");
        City city1 = new City("Jessore", "Khulna");
        City city2 = new City("Oxygen", "Chittagong");
        cityList.add(city);
        cityList.add(city1);
        cityList.add(city2);

        List<City> cityorder=cityList.getCities(0);
        assertEquals("Gulisthan",cityorder.get(0).getCityName());
        assertEquals("Jessore",cityorder.get(1).getCityName());
        assertEquals("Oxygen",cityorder.get(2).getCityName());


        List<City> provinceorder=cityList.getCities(1);
        assertEquals("Oxygen",provinceorder.get(0).getCityName());
        assertEquals("Gulisthan",provinceorder.get(1).getCityName());
        assertEquals("Jessore",provinceorder.get(2).getCityName());




    }

}
