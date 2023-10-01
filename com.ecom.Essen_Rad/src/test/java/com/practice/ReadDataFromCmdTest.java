package com.practice;

import org.testng.annotations.Test;

public class ReadDataFromCmdTest {

	
	@Test
	public void cmdRead() {
		String browser = System.getProperty("browser");
		String aUrl = System.getProperty("admin_url");
		String aUName = System.getProperty("admin_username");
		String aPwd = System.getProperty("admin_password");
		
		System.out.println("Browser : "+browser);
		System.out.println("Admin URL : "+aUrl);
		System.out.println("Admin Username : "+aUName);
		System.out.println("Admin Passsword : "+aPwd);
		
		
	}
}
