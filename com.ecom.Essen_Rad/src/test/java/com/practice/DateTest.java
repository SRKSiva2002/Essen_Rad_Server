package com.practice;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateTest {

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("d-M-Y hh-mm-ss");
		Date date = new Date();
		String d=dateFormat.format(date);
		System.out.println(d);
	}
}
