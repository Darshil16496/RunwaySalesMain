package package_practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderExampleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String MonthandYear = "July 2024";
		int date = 25;
		WebDriverManager.chromedriver().setup();
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.goibibo.com/");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		cd.findElement(By.xpath("//span[text()='Departure']")).click();
		String actual = "//div[text()='"+MonthandYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextArrow= "//span[@aria-label='Next Month']";
		
		for(;;) {
			try {
				cd.findElement(By.xpath(actual)).click();
				break;
			}
			catch(Exception e) {
				cd.findElement(By.xpath(nextArrow)).click();
			}
		}
		cd.findElement(By.xpath("//span[text()='Done']")).click();
		Thread.sleep(3000);
		System.out.println(cd.getCurrentUrl());
		cd.close();	
	}

}
