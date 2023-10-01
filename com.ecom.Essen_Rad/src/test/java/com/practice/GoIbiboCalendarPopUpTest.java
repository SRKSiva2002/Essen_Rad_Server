package com.practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoIbiboCalendarPopUpTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		int onDate=20; String onMonth="September 2023";
		int reDate=20; String reMonth="March 2024";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[text()='"+onMonth+"']/ancestor::div[@class='DayPicker-Month']//p[text()='"+onDate+"']")).click();
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		driver.findElement(By.xpath("//span[.='Return']")).click();
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+reMonth+"']/ancestor::div[@class='DayPicker-Month']//p[text()='"+reDate+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}	
		}
		driver.findElement(By.xpath("//span[.='Done']")).click();
		driver.findElement(By.xpath("//a[.='Cancel']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
