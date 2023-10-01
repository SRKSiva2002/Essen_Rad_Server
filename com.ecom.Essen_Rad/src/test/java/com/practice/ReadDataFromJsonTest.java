package com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.xdevapi.JsonParser;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Throwable {
		JSONParser jp = new JSONParser();
		JSONObject obj = (JSONObject) jp.parse(new FileReader(".\\src\\test\\resources\\Json.json"));

		String username=(String) obj.get("username");
		String url=(String) obj.get("url");
		String pwd=(String) obj.get("password");
		String browser=(String) obj.get("browser");
		
		System.out.println(url);
		System.out.println(username);
		System.out.println(pwd);
		System.out.println(browser);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		driver.quit();
	}
}
