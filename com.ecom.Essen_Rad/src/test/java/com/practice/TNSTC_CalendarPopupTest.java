package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TNSTC_CalendarPopupTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		int onDate=31;
		int reDate=20;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.tnstc.in/");
		driver.findElement(By.id("txtdeptDateOtrip")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='"+onDate+"']")).click();
		driver.findElement(By.id("txtdeptDateRtrip")).click();
		driver.findElement(By.xpath("//span[.='Next']")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[.='"+reDate+"']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}
