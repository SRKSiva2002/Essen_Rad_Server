package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ICC_ScotlandPresentTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.icc-cricket.com/");
		WebElement target = driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']//button[@class='linked-list__dropdown-label js-dropdown-btn' and contains(text(),'Rankings')]"));
		Actions a= new Actions(driver);
		a.moveToElement(target).perform();
		driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']//a[@href='/rankings/mens/team-rankings']")).click();
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
		String sc="Scotland";
		int count=0;
		int tCount = teams.size();
				for (int i = 0; i < tCount; i++) {
					String team=teams.get(i).getText();
					if (team.contains(sc)) {
						count++;
					}
				}
				if (count>0) {
					System.out.println("Scotland is present in table");
				}
				else {
					System.out.println("Scotland is not present in table");
				}
				driver.quit();
	}
}
