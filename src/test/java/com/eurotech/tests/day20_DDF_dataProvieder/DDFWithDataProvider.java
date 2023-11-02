package com.eurotech.tests.day20_DDF_dataProvieder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFWithDataProvider {
    @DataProvider
    public Object [][] tvAndRating(){
        String [][] data= {
                {"GAme of Thrones","9"},
                {"Lupin","10"},
                {"Breaking Bad","8"},
                {"Power","9"},
                {"Queen","9"},
                {"GAme of Thrones","7"},
                {"Esaretin Bedeli","9"},
                {"Yesil Yol","9"}
        };
        return data;
    }

    @Test(dataProvider = "tvAndRating")
    public void testTvShow(String tvShow, String rating) {
        System.out.println("Tv Show " + tvShow + " has rating " + rating);
    }
}
