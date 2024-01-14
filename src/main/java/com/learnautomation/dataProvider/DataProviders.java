package com.learnautomation.dataProvider;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	  @DataProvider(name = "LoginTestData")
	    public static Object[][] getLoginTestData() 
	  	{
	        List<Map<String, String>> testData = ExcelReader.getDataFromExcel("LoginData","/TestData/TestData.xlsx");
	        return convertListOfMapsToArray(testData);
	    }
	
	@DataProvider(name = "TestDataForRegistration")
	public static Object [][] getDataForRegsiterUser()
	{
		List<Map<String, String>> testData =ExcelReader.getDataFromExcel("RegisterUser","/TestData/TestData.xlsx");
		
		return convertListOfMapsToArray(testData);
	}
	
	  private static Object[][] convertListOfMapsToArray(List<Map<String, String>> testData) 
	  {
	        Object[][] arr = new Object[testData.size()][1];
	        for (int i = 0; i < testData.size(); i++) 
	        {
	            arr[i][0] = testData.get(i);
	        }
	        return arr;
	    }
	  
	  
	
}
