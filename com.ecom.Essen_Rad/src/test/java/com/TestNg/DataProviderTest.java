package com.TestNg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.ExcelUtitlity;
import com.Essan_Rad.GenericUtils.PathConstant;


public class DataProviderTest {

	@Test(dataProvider = "bike")
	public void executeBike(String brand,String model,int price, int year) {
		System.out.println(brand+"---"+model+"---"+price+"---"+year);
	}
	@DataProvider()
	public Object[][] vegMenu() {
		Object [][]obj = new Object[2][3];
		
		obj[0][0]="Paneer butter masala";
		obj[0][1]=150;
		obj[0][2]="full";
		
		obj[1][0]="Mushroom Biriyani";
		obj[1][1]=300;
		obj[1][2]="full";
		
		return obj;
	}
	@DataProvider()
	public Object[][] bike() {
		Object [][]obj = new Object[4][4];
		
		obj[0][0]="KTM";
		obj[0][1]="Duke 390";
		obj[0][2]=380000;
		obj[0][3]=2023;
		
		obj[1][0]="RE";
		obj[1][1]="Himalayan 450";
		obj[1][2]=420000;
		obj[1][3]=2024;
		
		obj[2][0]="RE";
		obj[2][1]="Interceptor 600";
		obj[2][2]=360000;
		obj[2][3]=2023;
		
		obj[3][0]="Kawazaki";
		obj[3][1]="Ninja Z900";
		obj[3][2]=950000;
		obj[3][3]=2024;
		
		return obj;
	}
	
	@DataProvider()
	public Object[][] bikeBrands() throws Throwable {
		ExcelUtitlity eLib= new ExcelUtitlity();
		Object[][] value = eLib.readMultipleDataForDataProvider("Bike");
		return value;
		
	}
}
