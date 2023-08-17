package package_practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyFileTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver cd;
		FileInputStream fis = new FileInputStream(".\\test\\resources\\commonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String url = pobj.getProperty("UrlActi");
		String browser = pobj.getProperty("Browseract");
		String username = pobj.getProperty("UsernameAct");
		String password = pobj.getProperty("PasswordAct");
		if(browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			
			cd = new ChromeDriver();
			cd.manage().window().maximize();
			
		}else if(browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.chromedriver().setup();
			cd = new FirefoxDriver();
			cd.manage().window().maximize();
			
		}else {
			WebDriverManager.chromedriver().setup();
			cd = new ChromeDriver();
			cd.manage().window().maximize();
		}
		cd.get(url);
		cd.findElement(By.id("username")).sendKeys(username);
		cd.findElement(By.name("pwd")).sendKeys(password);
		cd.findElement(By.id("loginButton")).click();
		
		Thread.sleep(1000);
		cd.close();
	}

}
