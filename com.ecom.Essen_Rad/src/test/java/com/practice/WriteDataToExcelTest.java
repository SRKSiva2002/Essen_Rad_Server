package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Hotels");
		sheet.createRow(10).createCell(0).setCellValue("JennyResidency");
		sheet.getRow(10).createCell(1).setCellValue("Coimbatore");
		sheet.createRow(11).createCell(0).setCellValue("Marrit");
		sheet.getRow(11).createCell(1).setCellValue("Bangalore");
		FileOutputStream fout= new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fout);
		int ls = sheet.getLastRowNum();
		int lc=sheet.getRow(1).getLastCellNum();
		for (int i = 1; i <= ls; i++) {
			for (int j = 0; j < lc; j++) {
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+"  ");
			}
			System.out.println();
		}
		wb.close();
	}
}
