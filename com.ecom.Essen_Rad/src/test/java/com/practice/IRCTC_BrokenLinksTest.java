package com.practice;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IRCTC_BrokenLinksTest {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int linkCount=allLinks.size();
		System.out.println("Total links"+linkCount);
		ArrayList<String> brokenLink=new ArrayList<String>();
		for (int i = 0; i < linkCount; i++) {
			String link=allLinks.get(i).getAttribute("href");
			URL url=null;
			int sCode=0;
			try {
				url=new URL(link);
				HttpsURLConnection https= (HttpsURLConnection) url.openConnection();
				sCode=https.getResponseCode();
				System.out.println(sCode);
				if (sCode>=400) {
					brokenLink.add(link);
				}
			} catch (Exception e) {
			}
			
		}
		int brokenCount=brokenLink.size();
		System.out.println("Broken links are"+brokenCount);
		if (brokenCount>0) {
			for (String s : brokenLink) {
				System.out.println(s);
			}
		}
		else {
			System.out.println("No broken links found");
		}
		driver.close();
		
	}
}
