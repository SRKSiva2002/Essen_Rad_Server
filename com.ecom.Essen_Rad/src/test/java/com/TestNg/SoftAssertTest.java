package com.TestNg;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SoftAssertTest{

	SoftAssert sa = new SoftAssert();
	@Test
	public void softAssert1() {
		System.out.println("---Soft Assert 1---");
		System.out.println("---Soft Assert 2---");
		System.out.println("---Soft Assert 3---");
		sa.assertEquals("V", "V");
		System.out.println("---Soft Assert 4---");
		System.out.println("---Soft Assert 5---");
		sa.assertAll();
	}
	
	@Test
	public void softAssert2() {
		System.out.println("---Soft Assert 6---");
		sa.fail();
		System.out.println("---Soft Assert 7---");
		sa.assertAll();
	}
	
}
