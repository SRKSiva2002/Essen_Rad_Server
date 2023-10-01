package com.practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EpfoBrokenLinksTest {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.epfindia.gov.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		ArrayList<String> s=new ArrayList<String>();
		int broken=s.size();
		int count=allLinks.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String link=allLinks.get(i).getAttribute("href");
			URL url=null;
			int statusCode=0;
			try {
				url=new URL(link);
				HttpsURLConnection https= (HttpsURLConnection) url.openConnection();
				statusCode=https.getResponseCode();
				System.out.println(statusCode);
				if (statusCode>=400) {
				s.add(link);
				System.out.println(link);
				}
			} catch (Exception e) {
				
			}
		}
		if (broken>0) {
			for (String string : s) {
				System.out.println("All the broken links"+broken);
				System.out.println(string);
			}
		}
		else {
			System.out.println("There are no broken links");
		}
		
		driver.close();
	}

}
