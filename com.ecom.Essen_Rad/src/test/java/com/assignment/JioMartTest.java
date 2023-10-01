package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jiomart.com/");
		String groceryName="Personal";
		Actions a= new Actions(driver);
		WebElement grocery = driver.findElement(By.xpath("//a[.='Groceries']"));
		a.moveToElement(grocery).perform();
		WebElement gList = driver.findElement(By.xpath("//a[contains(text(),'"+groceryName+"') and contains(@id,'nav_link')]"));
		a.moveToElement(gList).perform();
		List<WebElement> lDetails = driver.findElements(By.xpath("//a[contains(text(),'"+groceryName+"') and contains(@id,'nav_link')]/following-sibling::div//a"));
		System.out.println("List in grocery "+groceryName+" are ");
		for (WebElement f : lDetails) {
			System.out.println(f.getText());
		}
		driver.quit();
	}
}
