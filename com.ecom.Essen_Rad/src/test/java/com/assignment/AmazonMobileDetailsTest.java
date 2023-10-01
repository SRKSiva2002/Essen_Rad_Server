package com.assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonMobileDetailsTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String mBrand="Oppo";
		Actions a = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("phone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement tBrand = driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[contains(.,'Brand')]"));
		a.scrollToElement(tBrand);
		for (;;) {
			try {
				driver.findElement(By.xpath("//div[@id='brandsRefinements']//span[.='"+mBrand+"']")).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='a-expander-prompt']")).click();
			}
		}
		List<WebElement> mobileDetails = driver.findElements(By.xpath("//span[@class='a-price']//span[@class='a-offscreen'][number(translate(text(),'₹,',''))<20000]/ancestor::div[@class='sg-row']/preceding-sibling::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(mobileDetails.size()+" "+ mBrand+" mobile details which are below than 20000");
		for (WebElement m : mobileDetails) {
			System.out.println(m.getText());
		}
	driver.quit();
	}
	
}
