package com.learnautomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelReader 
{
	
	 public static List<Map<String, String>> getDataFromExcel(String sheetName,String inputFile) 
	 {
	        List<Map<String, String>> dataList = new ArrayList<>();

	        try (XSSFWorkbook wbWorkbook = new XSSFWorkbook(
	        		new FileInputStream(new File(System.getProperty("user.dir") + inputFile)))) 
	        {
	            int rowCount = wbWorkbook.getSheet(sheetName).getPhysicalNumberOfRows();
	          
	            for (int i = 1; i < rowCount; i++) 
	            {
	                Map<String, String> dataMap = new HashMap<>();

	                for (int j = 0; j < wbWorkbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells(); j++) 
	                {
	                    CellType type = wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getCellType();
	                    String valueString = "";

	                    if (type == CellType.STRING) 
	                    {
	                        valueString = wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
	                        System.out.println("value is "+valueString);
	                    } 
	                    else if (type == CellType.NUMERIC) 
	                    {
	                        double doubleValue = wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getNumericCellValue();
	                        valueString = String.valueOf(doubleValue);
	                    } 
	                    else if (type == CellType.BOOLEAN) 
	                    {
	                        boolean booleanValue = wbWorkbook.getSheet(sheetName).getRow(i).getCell(j).getBooleanCellValue();
	                        valueString = String.valueOf(booleanValue);
	                    }

	                    dataMap.put(wbWorkbook.getSheet(sheetName).getRow(0).getCell(j).getStringCellValue(), valueString);
	                }

	                dataList.add(dataMap);
	            }

	        } catch (IOException e) {
	            Reporter.log("LOG:FAIL - Could not load the file " + e.getMessage(), true);
	        }

	        return dataList;
	    }

}
