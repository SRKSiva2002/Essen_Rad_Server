package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetAllRestaurantNamesTest {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		driver.get("http://rmgtestingserver/domain/Online_Food_Ordering_System/admin");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("codeastro");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[.='Restaurant']")).click();
		driver.findElement(By.linkText("All Restaurant")).click();
		List<WebElement> restNames = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]"));
		for (WebElement w : restNames) {
			System.out.println(w.getText());
		}
		driver.quit();
	}
}
