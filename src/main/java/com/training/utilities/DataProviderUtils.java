package com.training.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProviderUtils 
{
	private static XSSFSheet excelwSheet;
	private static XSSFWorkbook excelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static Object [] [] getTableArray (String FilePath, String SheetName) throws Exception
	{
		String[][] tabArray = null;
		try 
		{
			FileInputStream excelFile = new FileInputStream(FilePath);

			excelWBook = new XSSFWorkbook(excelFile);

			excelwSheet = excelWBook.getSheet(SheetName);

			int startRow = 1;
			int startCol = 1;
			int ci, cj;
			int totalRows = excelwSheet.getLastRowNum();
			
		
			int totalCols = 2;
			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) 
			{
				cj = 0;
				for (int j = startCol; j <= totalCols; j++, cj++)

				{
					// tabArray [ci] [cj]= getCellData (i,j) ;
				}
			}
		}
			
			
		
			catch(Exception e)
		{
			System.out.println(e);
		}
		return tabArray;
	}
}
