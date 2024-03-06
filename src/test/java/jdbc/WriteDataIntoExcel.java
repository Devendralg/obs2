package jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Scanner sc=new Scanner(System.in);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.createSheet("Sheet3");
		
		for (int i = 0; i <=2; i++) {
			Row row = sheet.createRow(i);

			for (int j = 0; j <=1; j++) {
				System.out.println("Enter Cell Value");
				row.createCell(j).setCellValue(sc.next());
				
				
			}
			
		}
//		Row row = sheet.createRow(0);
//		row.createCell(0).setCellValue("Devendra");
//		row.createCell(1).setCellValue("Dheeraj");
//		
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\testdata.xlsx");
		book.write(fout);
		book.close();
		
		
		
		
	}

}
