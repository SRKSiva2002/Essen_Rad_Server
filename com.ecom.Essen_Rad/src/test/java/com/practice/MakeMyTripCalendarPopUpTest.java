package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v115.runtime.model.ExceptionDetails;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripCalendarPopUpTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		int onDate=20; String onMonth="February 2024";
		int reDate=20; String reMonth="May";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		Actions a=new Actions(driver);
		a.moveByOffset(0, 80).click().perform();
		//Thread.sleep(3000);
		//a.moveByOffset(0, 80).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		for (;;) {
		try {
			driver.findElement(By.xpath("//div[text()='"+onMonth+"']/ancestor::div[@class='DayPicker-Month']//p[text()='"+onDate+"']")).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}	
		}
		driver.findElement(By.xpath("//span[.='Return']")).click();
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+reMonth+"' and span[text()='2024']]/ancestor::div[@class='DayPicker-Month']//p[text()='"+reDate+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}	
			}
		Thread.sleep(3000);
		driver.quit();
	}
}
