package com.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OlympicsMedalTableTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		String country="Türkiye";
		String cRow = driver.findElement(By.xpath("//span[contains(@class, 'styles__CountryName-sc-fehzzg-6') and contains(.,'"+country+"')]/ancestor::div[contains(@data-row-id,'country-medal-row')]")).getAttribute("data-row-id");
		String row=cRow.substring(14);
		String gold = driver.findElement(By.xpath("//span[contains(@class, 'styles__CountryName-sc-fehzzg-6') and contains(.,'"+country+"')]/ancestor::div[contains(@data-row-id,'country-medal-row')]/following-sibling::div[@data-medal-id='gold-medals-"+row+"']//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']")).getText();
		String silver = driver.findElement(By.xpath("//span[contains(@class, 'styles__CountryName-sc-fehzzg-6') and contains(.,'"+country+"')]/ancestor::div[contains(@data-row-id,'country-medal-row')]/following-sibling::div[@data-medal-id='silver-medals-"+row+"']//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']")).getText();
		String bronze = driver.findElement(By.xpath("//span[contains(@class, 'styles__CountryName-sc-fehzzg-6') and contains(.,'"+country+"')]/ancestor::div[contains(@data-row-id,'country-medal-row')]/following-sibling::div[@data-medal-id='bronze-medals-"+row+"']//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']")).getText();
		String total = driver.findElement(By.xpath("//span[contains(@class, 'styles__CountryName-sc-fehzzg-6') and contains(.,'"+country+"')]/ancestor::div[contains(@data-row-id,'country-medal-row')]/following-sibling::div[@data-medal-id='total-medals-"+row+"']//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']")).getText();
		driver.quit();
		System.out.println("List of medals won by "+country+" are ");
		System.out.println("Gold : "+gold);
		System.out.println("Silver : "+silver);
		System.out.println("Bronze : "+bronze);
		System.out.println("Total : "+total);
		
	}
	
}
