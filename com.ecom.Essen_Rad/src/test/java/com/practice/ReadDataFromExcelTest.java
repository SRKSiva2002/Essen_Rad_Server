package com.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, Throwable {
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Hotels");
		int ls = sheet.getLastRowNum();
		int lc=sheet.getRow(1).getLastCellNum();
		for (int i = 1; i <= ls; i++) {
			for (int j = 0; j < lc; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"  ");
			}
			System.out.println();
		}
	}
}
