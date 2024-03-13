package com.dataprovider;
import org.testng.annotations.DataProvider;

public class DP
{
    @DataProvider (name = "dp")
     public Object[][] dpMethod(){
        return new Object[][] {{"In class of DataProvider"}};
     } 
}