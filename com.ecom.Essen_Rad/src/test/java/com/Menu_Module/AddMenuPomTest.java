package com.Menu_Module;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.GenericUtils.DataBaseUtility;
import com.Essan_Rad.GenericUtils.ExcelUtitlity;
import com.Essan_Rad.GenericUtils.FileUtility;
import com.Essan_Rad.GenericUtils.JavaUtility;
import com.Essan_Rad.GenericUtils.ListenerImplementationClass;
import com.Essan_Rad.GenericUtils.WebdriverUtility;
import com.Essan_Rad.ObjectRepo.AddMenuPage;
import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;
import com.google.common.io.Files;

public class AddMenuPomTest extends BaseClass {

	@Test(groups = "smoke")
	public void AddMenu() throws Throwable {
		String aUrl = fLib.readPropertyFile("admin_url");
		String username=fLib.readPropertyFile("admin_username");
		String password=fLib.readPropertyFile("admin_password");
		driver.get(aUrl);
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(username, password);
		
		// read data from excel file
		HashMap<String, String> data = eLib.readMultipleDataFromExcel("Menu", 0, 1);
		String restName = eLib.readDataFromExcelFile("Menu", 2, 4);

		AdminPanelPage app = new AdminPanelPage(driver);
		int intialCount = app.getDashboardCount(driver, "Dishes");
		app.clickAddMenu();
		AddMenuPage amp = new AddMenuPage(driver);
		String actualMenuName = amp.addMenu(data, driver, jLib, restName);
		
		int afterCount = app.getDashboardCount(driver, "Dishes");

		if (intialCount < afterCount) {
			Assert.assertTrue(true);
			Reporter.log("Menu is created", true);
		} else {
			Assert.assertTrue(false, "Menu is not created");
		}
		
	}

}
