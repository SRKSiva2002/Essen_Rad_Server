package com.Restaurant_Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Essan_Rad.GenericUtils.BaseClass;
import com.Essan_Rad.GenericUtils.DataBaseUtility;
import com.Essan_Rad.GenericUtils.ExcelUtitlity;
import com.Essan_Rad.GenericUtils.FileUtility;
import com.Essan_Rad.GenericUtils.JavaUtility;
import com.Essan_Rad.GenericUtils.ListenerImplementationClass;
import com.Essan_Rad.GenericUtils.WebdriverUtility;
import com.Essan_Rad.ObjectRepo.AddCategoryPage;
import com.Essan_Rad.ObjectRepo.AdminLoginPage;
import com.Essan_Rad.ObjectRepo.AdminPanelPage;
import com.Essan_Rad.ObjectRepo.EditCategoryPage;

public class EditCategoryPomTest extends BaseClass {

	@Test(groups = "regression")
	public void EditCategory() throws Throwable {

		String aUrl = fLib.readPropertyFile("admin_url");
		String aUname = fLib.readPropertyFile("admin_username");
		String aPwd = fLib.readPropertyFile("admin_password");
		driver.get(aUrl);
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.adminLogin(aUname, aPwd);
		
		AdminPanelPage app=new AdminPanelPage(driver);
		app.clickAddCategory();
		
		String catName=eLib.readDataFromExcelFile("Category", 1, 1)+jLib.getRandomNumber();
		AddCategoryPage acp = new AddCategoryPage(driver);
		acp.addCategory(catName);
		acp.validateCategory(driver, catName);
		acp.clickOnEditCategory(driver, catName);
		
		String updatedCatName=eLib.readDataFromExcelFile("Category", 1, 1)+jLib.getRandomNumber();
		EditCategoryPage ecp = new EditCategoryPage(driver);
		ecp.editCategory(updatedCatName);
		app.clickAddCategory();
		ecp.validateCategory(driver, updatedCatName);
	}
}
