package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecuteAppFromCmdTest {

	@Test
	public void excecuteAppCmd() {
			String browser = System.getProperty("browser");
			String aUrl = System.getProperty("admin_url");
			String aUName = System.getProperty("admin_username");
			String aPwd = System.getProperty("admin_password");
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(aUrl);
			driver.findElement(By.name("username")).sendKeys(aUName);
			driver.findElement(By.name("password")).sendKeys(aPwd);
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//img[@class='profile-pic']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			driver.quit();
	}
}
