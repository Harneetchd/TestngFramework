package com.dataprovider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DPDemo {
	
	@DataProvider (name = "dp")
	public Object[][] dpMethod(){
		return new Object[][] {{2, 3 , 6, 36}, {5, 7, 2, 70}};
	}
	
      @Test (dataProvider = "dp")
      public void myTest (int a, int b, int c, int result) {
	     int r = a * b *c;
	     AssertJUnit.assertEquals(result, r);
      }
      
      @Test (dataProvider = "dp", dataProviderClass = DP.class)
      public void myTest2 (String val) {
        System.out.println("In DataProvider Test called by className : " + val);
      }
      
      @DataProvider (name = "dp2")
      public Object[][] dataProviderMethod (Method m){
  		switch (m.getName()) {
  		case "Sum": 
  			return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
  		case "Diff": 
  			return new Object[][] {{3, 2, 1}, {7, 2, 5}};
  		}
  		return null;
  		
  	}
  	
  	@Test (dataProvider = "dp2")
  	 public void Sum (int a, int b, int result) {
  	      int sum = a + b;
  	      AssertJUnit.assertEquals(result, sum);
  	 }
  	  
  	@Test (dataProvider = "dp2")
  	public void Diff (int a, int b, int result) {
  	      int diff = a - b;
  	      AssertJUnit.assertEquals(result, diff);
  	 }

 }
