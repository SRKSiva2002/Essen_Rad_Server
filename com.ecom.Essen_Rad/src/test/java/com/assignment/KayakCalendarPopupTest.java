package com.assignment;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.xdevapi.DocResultImpl;

public class KayakCalendarPopupTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int onYear= 2023; int onDate=11; String onMonth="September";
		int reYear=2023; int reDate=20; String reMonth="October";
		String fCity="DEL"; String tCity="BLR"; String currency="USD";
		driver.get("https://www.kayak.co.in/flights");
		Actions a =new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='vvTc-item-value']/following-sibling::div[@class='vvTc-item-close']/div[@class='vvTc-item-button']")).click();
		driver.findElement(By.xpath("//input[@class='k_my-input' and @placeholder='From?']")).sendKeys(fCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='JyN0-name-row']/span[contains(text(),'"+fCity+"')]/ancestor::div[@class='JyN0-item JyN0-pres-item-mcfly']//input[@class='PVIO-input']")).click();
		driver.findElement(By.xpath("//input[@class='k_my-input' and @placeholder='To?']")).sendKeys(tCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='JyN0-name-row']/span[contains(text(),'"+tCity+"')]/ancestor::div[@class='JyN0-item JyN0-pres-item-mcfly']//input[@class='PVIO-input']")).click();
		driver.findElement(By.xpath("//span[@class='sR_k-date' and @aria-label='Start date calendar input']//span[@class='sR_k-value']")).click();
		for (;;) {
			try {
				WebElement target = driver.findElement(By.xpath("//div[@class='wHSr-monthName' and contains(.,'"+onMonth+"')]/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[contains(@aria-label,'"+onMonth+"')and contains(@class,'mkUa-mod-colorblind') and contains(text(),'"+onDate+"')]"));
				a.moveToElement(target).click().perform();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class='Iqt3-button-container']/ancestor::div[@class='ATGJ-navWrapper ATGJ-prev-month']//span[@class='tUEz-icon']/*[@role='img']")).click();
			}
		}
		//driver.findElement(By.xpath("//span[@class='sR_k-date' and @aria-label='End date calendar input']//span[@class='sR_k-value']")).click();
		for (;;) {
			try {
				WebElement target = driver.findElement(By.xpath("//div[@class='wHSr-monthName' and contains(.,'"+reMonth+" "+reYear+"')]/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[contains(@aria-label,'"+reMonth+"')and contains(@class,'mkUa-mod-colorblind') and contains(text(),'"+reDate+"')]"));
				a.moveToElement(target).click().perform();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class='Iqt3-button-container']/ancestor::div[@class='ATGJ-navWrapper ATGJ-next-month']//span[@class='tUEz-icon']/*[@role='img']")).click();
			}
		}
		Thread.sleep(2000);
		int target = driver.findElement(By.xpath("//span[contains(.,'adult')]")).getLocation().getY();
		a.scrollByAmount(0, -target).perform();
		driver.findElement(By.xpath("//span[contains(.,'adult')]")).click();
		int adultCount=5;
		while (adultCount>1) {
			driver.findElement(By.xpath("//span[contains(.,'Adults')]/../following-sibling::div/button[@class='bCGf-mod-theme-default' and @aria-label='Increment']/*[@role='img']")).click();
			adultCount--;
		}
		//driver.findElement(By.xpath("//button[@aria-label='Indian rupee']/span[contains(.,'₹')]")).click();
		//driver.findElement(By.xpath("//div[@class='chXn-content-top-currencies']//div[text()='United States dollar']")).click();
		//driver.findElement(By.xpath("//div[@class='Iqt3-button-content' and .='This visit only']")).click();
		driver.findElement(By.xpath("//div[@class='Iqt3-button-content']/*[@class='c8LPF-icon']")).click();
		Thread.sleep(5000);
		Set<String> whs = driver.getWindowHandles();
		for (String s : whs) {
				driver.switchTo().window(s);
		}
		driver.manage().timeouts().getPageLoadTimeout();
		driver.findElement(By.xpath("//div[text()='Other sort']")).click();
		int tar = driver.findElement(By.xpath("//span[.='Slowest']")).getLocation().getY();
		a.moveByOffset(0, tar);
		driver.findElement(By.xpath("//span[.='Slowest']")).click();
		String sprice = driver.findElement(By.xpath("(//div[@class='f8F1-price-text'])[1]")).getText();
		driver.quit();
		System.out.println(sprice);
		char []ch=sprice.toCharArray(); int price=0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i]>='0'&&ch[i]<='9') {
				price=(price*10)+(ch[i]-48);
			}
		}
		System.out.println(price);
		if (price<20000) {
			System.out.println("1st flight ticket price is less than 20000");
		}
		else {
			System.out.println("1st flight ticket price is more than 20000");
		}
	}
}
