package excelutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	//method to read data from excel
	public static String[][] read(int row1,int row2)
	{
		int row,column,i,j;
		String[][] testdata= new String[1][2];
		File f=new File("src/test/resources/TestData/LoginData.xlsx");
		try 
		{
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("Sheet1");
		for(row=row1,i=0;row<row2;row++,i++)
		{
		XSSFRow Row = sh.getRow(row);
		
		for(column=0,j=0;column<2;column++,j++)
		{
		XSSFCell cell=Row.getCell(column);
		testdata[i][j]=cell.getStringCellValue();
		}
		}
		}
		catch (FileNotFoundException e) 
		{
		e.printStackTrace();
		}
		catch (IOException e1) 
		{
		e1.printStackTrace();
		}
		return testdata;
	}
}
