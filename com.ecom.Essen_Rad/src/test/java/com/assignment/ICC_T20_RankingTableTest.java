package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ICC_T20_RankingTableTest {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String matches="40";
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> teams = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3][@class='table-body__cell u-center-text' and text()<"+matches+"]/preceding-sibling::td[@class='table-body__cell rankings-table__team']/span[@class='u-hide-phablet']"));
		int count=teams.size();
		System.out.println(count+" Cricket teams which played below "+matches+" matches in T20's are as follows : ");
		for (WebElement t : teams) {
			System.out.println(t.getText());
		}
		driver.close();
	}
}
