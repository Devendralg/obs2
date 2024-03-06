package jdbc;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		String value = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(value);
		int lrow = sheet.getLastRowNum();
		System.out.println(lrow);
		int lcell = sheet.getRow(0).getLastCellNum();
		for (int i = 0; i <= lrow; i++) {
			for (int j = 0; j < lcell; j++) {
				String value1 = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value1+"                   ");
			}
			System.out.println();
			
		}
		
	}

}
