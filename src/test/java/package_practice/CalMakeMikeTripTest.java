package package_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalMakeMikeTripTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String MonthandYear = "January 2024";
		int date = 17;
		//Launch Browser
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.makemytrip.com/");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions act = new Actions(cd);
//		cd.navigate().refresh();
		//cd.findElement(By.className("we_close")).click();
//		act.moveByOffset(60, 60).click().perform();
		
		
		act.moveByOffset(60, 0).click().perform();
		
		act.moveByOffset(60, 40).click().perform();
		
		
		cd.findElement(By.xpath("//label[@for='departure']")).click();
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
		Thread.sleep(3000);
		cd.close();
	}

}
