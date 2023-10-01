package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadiS9StandingsTableTest {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String team="Gujarat";
		driver.get("https://www.prokabaddi.com/standings");
		List<WebElement> details = driver.findElements(By.xpath("//div[@class='team-name']/p[contains(text(),'"+team+"')]/ancestor::div[@class='row-head']/div[*]/p[@class!='position-indicator position-up']"));
		List<WebElement> headings = driver.findElements(By.xpath("//div[@class='table-data team']/p[contains(text(),'Team')]/ancestor::div[@class='table-head']//div[*]/p[text()!='Team' and .!='Form']"));
		System.out.println("Team - "+team);
		for (int i = 0; i < details.size(); i++) {
			System.out.println(headings.get(i).getText()+" - "+details.get(i).getText());
		}
		driver.quit();
	}
}
