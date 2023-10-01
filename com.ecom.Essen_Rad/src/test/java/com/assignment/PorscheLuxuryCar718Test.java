package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PorscheLuxuryCar718Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.porsche.com/middle-east/_india_/");
		driver.findElement(By.xpath("//div[@class='m-107-info__headline' ]//span[.='718']/ancestor::div[@class='m-107-info']//span[.='All Models']")).click();
		driver.findElement(By.xpath("//div[@class='m-14-model-name' and contains(.,'718')]/following-sibling::div[@class='m-14-model-price' and text()='from INR 14,772,000']")).click();
		driver.findElement(By.xpath("//div[@data-filter='coupe']//a[@class='m-364-tech-specs gui-btn gui-btn-transparent-with-outline gui-link-with-arrow']//span[.='Technical Specs']")).click();
		List<WebElement> data = driver.findElements(By.xpath("//div[@class='m-309-accordion-wrapper']//table/tbody/tr[*]//span"));
		for (int i = 0; i < data.size(); i++) {
				WebElement d = data.get(i);
				System.out.println(d.getText());
			}
		driver.quit();
		
	}
}
