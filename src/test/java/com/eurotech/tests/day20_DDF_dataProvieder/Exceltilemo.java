package com.eurotech.tests.day20_DDF_dataProvieder;

import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Exceltilemo {
    @Test
    public void readExcelFile() {
        /** WHAT WE ARE GOING TO DO:
         * Create an object from ExcelUtil
         * it accepts two arguments
         * argument 1: location of the file(path)
         * argument 2: sheet that we want to open (sheetName)
         */

        ExcelUtil testData = new ExcelUtil("src/test/resources/Batch11_DevEx.xlsx","Test Data");
         // How many rows in the sheet

        System.out.println("testData.rowCount() = " + testData.rowCount()); // testData.rowCount() = 9
        // How manz columns in the sheet
        System.out.println("testData.columnCount() = " + testData.columnCount()); // testData.columnCount() = 5
         // get all columns names
        System.out.println("testData.getColumnsNames() = " + testData.getColumnsNames()); // testData.getColumnsNames() = [Username, Password, Title, Company, Name]


        List<Map<String,String>> dataList= testData.getDataList();
       // System.out.println("dataList = " + dataList);
        for (Map<String, String> oneRow : dataList) {

            System.out.println("oneRow = " + oneRow);
        }
        // How can i get third row ( jack Sparrow)

        System.out.println("dataList.get(2) = " + dataList.get(2));

        // How can i get Company(ZK GmbH)
        System.out.println("dataList.get(4).get(\"Company\") = " + dataList.get(4).get("Company"));
        // How can i get Titel
        System.out.println("dataList.get(4).get(\"Titel\") = " + dataList.get(4).get("Title"));

        // get all data as array

        String[][] dataArray= testData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        String[][] dataArrayWithoutFirst= testData.getDataArrayWithoutFirstRow();
        System.out.println("Arrays.deepToString(dataArrayWithoutFirst) = " + Arrays.deepToString(dataArrayWithoutFirst));
    }
}
