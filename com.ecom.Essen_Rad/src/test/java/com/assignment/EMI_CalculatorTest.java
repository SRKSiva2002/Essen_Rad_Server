package com.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EMI_CalculatorTest {


	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		Actions a = new Actions(driver);
	//	WebElement amount = driver.findElement(By.id("loanamount"));
		//amount.clear();
		//amount.sendKeys("1000000");
	//	amount.sendKeys(Keys.ENTER);
		WebElement t = driver.findElement(By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']/*[@class='highcharts-point'][15]"));
		a.moveToElement(t).perform();
		List<WebElement> t1 = driver.findElements(By.xpath("//*[@class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker highcharts-series-hover']/*[@class='highcharts-point']"));
		for (WebElement w : t1) {
			a.moveToElement(w).perform();
			List<WebElement> e = driver.findElements(By.xpath("//*[@class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*//*[contains(.,' ')]"));
			for (WebElement s : e) {
				System.out.println(s.getText());
			}
			System.out.println("-------------------------------");
		}
		driver.quit();

	}
}

