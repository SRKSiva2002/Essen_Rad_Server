package com.practice;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String aUrl = p.getProperty("admin_url");
		String aUname = p.getProperty("admin_username");
		String aPwd = p.getProperty("admin_password");
		String url = p.getProperty("url");
		String uname = p.getProperty("username");
		String pwd = p.getProperty("password");
		System.out.println("Browser : "+browser);
		System.out.println("Admin url : "+aUrl);
		System.out.println("Admin username : "+aUname);
		System.out.println("Admin password : "+aPwd);
		System.out.println("User url : "+url);
		System.out.println("User username : "+uname);
		System.out.println("User Password : "+pwd);
	}
}
