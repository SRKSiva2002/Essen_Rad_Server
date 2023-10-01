package com.practice;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class ColorCodeTest {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=iphone&crid=3L4D8OUP61SUZ&sprefix=iphone%2Caps%2C261&ref=nb_sb_noss_1");
		List<WebElement> color = driver.findElements(By.xpath("//span[.='Apple iPhone 14 (128 GB) - Starlight']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='s-color-swatch-inner-circle-border']"));
		Actions a = new Actions(driver);
		for (int i = 0; i < color.size(); i++) {
			WebElement each = color.get(i);
			a.moveToElement(each).perform();
			String c=each.getAttribute("aria-label");
			System.out.println(c);
			
		}
		driver.switchTo().newWindow(WindowType.TAB);
//		for(WebElement ele:color)
//		{
//			String res = ele.getCssValue("color");
//			System.out.println(res);
//		
//		}
//		WebElement res1 = driver.findElement(By.cssSelector(".puis-v20azwp0smsgc01ytmkntf1rk7n .s-color-swatch-container .s-color-swatch-outer-circle .s-color-swatch-inner-circle-fill .s-color-swatch-inner-circle-border"));
//		System.out.println(res1.getCssValue(null));
////		
//		
//		for (WebElement w : color) {
//			String co=w.getCssValue("aria-label");
//			System.out.println(co);
//			a.moveToElement(w).click().perform();
//		}
	}

}
