package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TourismTableTest {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		driver.get("http://rmgtestingserver/domain/Online_Tourism_Management_System/admin/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//span[.='Manage Enquiries']")).click();
		List<WebElement> names = driver.findElements(By.xpath("//table/tbody//tr[*]/td[2]/span[@class='bt-content']"));
		int count = names.size();
		System.out.println(count);
		/*for (WebElement e : names) {
			System.out.println(e.getText());
		}*/
		//for (int i = 0; i < count; i++) {
			WebElement w= names.get(3);
			String s=w.getText();
			System.out.println(s);
		//}
		driver.close();
		
	}
}
