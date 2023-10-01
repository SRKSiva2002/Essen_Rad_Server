package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class WriteIntoExcelMultipleTest {

	public static void main(String[] args) throws Throwable {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter number for rows to be added");
		int rsize=s.nextInt();
		String [] cola= new String[rsize];
		System.out.println("Enter values to store in column A");
		s.nextLine();
		for (int i = 0; i < cola.length; i++) {
			cola[i]=s.nextLine();
		}
		System.out.println("Enter column details to be column B");
		String [] colb=new String[rsize];
		for (int i = 0; i < cola.length; i++) {
			colb[i]=s.nextLine();
		}
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestWriteData.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int lc=sheet.getRow(0).getLastCellNum();
	//	Row r = sheet.getRow(100);
		System.out.println("Written in excel");
		for (int i = 1; i <= rsize; i++) {
			//Row cr = sheet.getRow(i);
			for (int j = 1; j < lc; j++) {
					sheet.createRow(i).createCell(j-1).setCellValue(cola[(i-1)]);
					sheet.getRow(i).createCell(j).setCellValue(colb[(i-1)]);
			}
		}
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\TestWriteData.xlsx");
		wb.write(fout);
		wb.close();
		
		
		
	}
}
