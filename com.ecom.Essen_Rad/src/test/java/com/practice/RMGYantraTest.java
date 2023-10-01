package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {

	private static ResultSet re;

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String name="Indis_Bistro-3";
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement( By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Sivabalan Selvaraj");
		WebElement dd = driver.findElement(By.xpath("//select[@name='status']"));
		Select s= new Select(dd);
		s.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		driver.close();
		Driver d = new Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query="select * from project where project_name='"+name+"';";
		ResultSet res = state.executeQuery(query);
		boolean f=false;
		while (res.next()) {
			String actual=res.getString(4);
			if (name.equalsIgnoreCase(actual)) {
				System.out.println(actual);
				f=true;
				break;
			}
		}
		if (f) {
			System.out.println("Project "+name+" is created");
		}
		else {
			System.out.println("Project "+name+" is not created");
		}
	}
}
