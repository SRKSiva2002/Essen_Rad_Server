package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;

public class WriteDataToPropertyTest {

	public static void main(String[] args) throws Throwable {
		File f = new File(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.setProperty("user_username", "ABCD");
		p.setProperty("user_url", "http://rmgtestingserver/domain/Online_Food_Ordering_System/");
		p.setProperty("user_password", "1234567");
		p.setProperty("user_browser", "chrome");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\Commondata.properties");
		p.store(fout, "Write data");
		fout.close();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		p.load(fis);
		String username=p.getProperty("user_username");
		String url=p.getProperty("user_url");
		String pwd=p.getProperty("user_password");
		String browser=p.getProperty("user_browser");
		
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
