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

public class BSNL_BrokenLinksTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://portal.bsnl.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int linkCount=allLinks.size();
		ArrayList<String> brokenLinks= new ArrayList<String>();
		
		for (int i = 0; i < linkCount; i++) {
			String link=allLinks.get(i).getAttribute("href");
			URL url= null;
			int sCode=0;
			try {
				url=new URL(link);
				HttpsURLConnection https= (HttpsURLConnection) url.openConnection();
				sCode=https.getResponseCode();
				if (sCode>=400) {
					brokenLinks.add(link);
				}
			} catch (Exception e) {
			}
		}
		int brokenCount=brokenLinks.size();
		System.out.println("Total broken links are :"+brokenCount);
		if (brokenCount>0) {
			for (String s : brokenLinks) {
				System.out.println(s);
			}
		}
	}
}
