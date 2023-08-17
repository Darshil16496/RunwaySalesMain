package com.crm.genericUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.LoginLocatorsPage;

public class BaseClass {

	public FileUtility fU = new FileUtility();
	public JavaUtility jU = new JavaUtility();
	public WebDriverUtility wU= new WebDriverUtility();
	public ExcelUtility eU = new ExcelUtility();
	public DatabaseUtility dU = new DatabaseUtility();
	public WebDriver cd;
	public static WebDriver scd;
	
	@BeforeSuite(alwaysRun = true)
	public void connectDB() throws Throwable {
		dU.connectDBcon();
		System.out.println("Database Connection");
	}
	
	
	@BeforeClass(alwaysRun = true)
	//@org.testng.annotations.Parameters("browser")
//	public void configureDb(String browser) {
//		if(browser.equalsIgnoreCase("firefox"))
//		{
//			cd = new FirefoxDriver();
//			
//		}else {
//			cd = new ChromeDriver();
//		}
//		
//		wU.maximizeWindow(cd);
//	}
	public void configureDb() {
		cd = new ChromeDriver();	
		scd = cd;
		wU.maximizeWindow(cd);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configureLogin() throws Throwable {
		String url = fU.getDataFromProperties("Url");
		String userName = fU.getDataFromProperties("Username");
		String password = fU.getDataFromProperties("Password");
		
		cd.get(url);
		
		LoginLocatorsPage llp = new LoginLocatorsPage(cd);
		llp.loginAction(userName, password);
		
		System.out.println("Login To the Application");
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void configureLogout() {
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.HomeActionsLogout(cd);
		System.out.println("Logout From the Application");
	}
	
	@AfterClass(alwaysRun = true)
	public void CloseBrowser() {
		cd.close();
		System.out.println("Close The Browser");
	}
	
	@AfterSuite(alwaysRun = true)
	public void CloseDbconnection() throws SQLException {
		
		dU.closeDbConnection();
		System.out.println("Close The Connection");
	}
}
