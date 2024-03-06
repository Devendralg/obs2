package com.obs.generic.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtils 
{
	/**
	 * This method is used to read data from excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		String value = book.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;

		
		
	}
	
	/**
	 * This method is used to write the data into existing excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExistingExcel(String sheetName,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		sheet.createRow(lastRowNum+1).createCell(cell).setCellValue(value);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}
	
	public void writeDataIntoExistingExcel(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		Row r = sheet.createRow(lastRowNum+1);
		r.createCell(cell).setCellValue(value);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}

	public void writeDebitPin(String sheetName,int row,String debitNo,String pin) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row r = sheet.getRow(row);
		r.createCell(6).setCellValue(debitNo);
		r.createCell(8).setCellValue(pin);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}

	
	/**
	 * This method is used for write data into new excel file
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoNewExcel(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		book.createSheet(sheetName).createRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}
	
	public HashMap<String, String> readMultipleDataFromExcel(String sheet,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int rowCount = sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (int i = 0; i < rowCount; i++) 
		{
			String key = sh.getRow(i).getCell(cell).getStringCellValue();
			String value = sh.getRow(i).getCell(cell+1).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
		
	}
	
	public Object[][] dataPrividertwoTwo(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum()+1;
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRowNum][lastCellNum];
		
		for(int i=0; i<lastRowNum; i++)
		{
			for (int j = 0; j < lastCellNum; j++)
			{
				 obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue().toString();
				
			}
		}
		return obj;

	}
	public void writeData(String sheetName,int row,int cell,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);
		
		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}
	
	public void writeApproved(String sheetName,int row,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
	//	int lastRowNum = sheet.getLastRowNum();
		Row r = sheet.getRow(row);
		r.createCell(1).setCellValue(value);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}

	public void writeDataFlipkart(String sheetName,int row,String name,String price) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row r = sheet.createRow(row);
		r.createCell(0).setCellValue(name);
		r.createCell(1).setCellValue(price);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}

	public void writeDataBookmyShow(String sheetName,int row,String name) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row r = sheet.createRow(row);
		r.createCell(0).setCellValue(name);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}
	public void writeDataBookmyShowTimes(String sheetName,int row,int cell,String name) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook book =	WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row r = sheet.getRow(row);
		r.createCell(cell).setCellValue(name);

		FileOutputStream fout = new FileOutputStream(IpathConstants.ExcelPath);
		book.write(fout);
	}




}
