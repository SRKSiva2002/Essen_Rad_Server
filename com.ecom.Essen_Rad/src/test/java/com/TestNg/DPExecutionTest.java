package com.TestNg;

import org.testng.annotations.Test;

public class DPExecutionTest {

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "vegMenu", invocationCount = 0)
	public void executeMenu(String dName,int price, String qty) {
		System.out.println(dName+"---"+qty+"---"+price);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "bike", invocationCount = 0)
	public void executeBike(String brand,String model,int price, int year) {
		System.out.println(brand+"---"+model+"---"+price+"---"+year);
	}
	
	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "bikeBrands")
	public void executeBike(String brand,String model,String price, String year) {
		System.out.println(brand+"---"+model+"---"+price+"---"+year);
	}
}
