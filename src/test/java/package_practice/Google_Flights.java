package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Google_Flights {

	@Test
	public void googleFlights() throws InterruptedException {
		
	WebDriver cd = new ChromeDriver();
	cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	cd.manage().window().maximize();
	cd.get("https://www.google.com/travel/flights");
//	cd.findElement(By.xpath("(//input[@class='II2One j0Ppje zmMKJ LbIaRd'])[2]")).sendKeys("surat");
	cd.findElement(By.xpath("(//input[@class='II2One j0Ppje zmMKJ LbIaRd'])[3]")).sendKeys("Surat");
	cd.findElement(By.xpath("//div[text()='Surat, Gujarat']")).click();
//	cd.findElement(By.xpath("(//input[@class='TP4Lpb eoY5cb j0Ppje' and @placeholder='Departure'])[1]")).click();
////	cd.findElement(By.xpath("//div[text()='October']/following-sibling::div[@jsname='Mgvhmd']//div[text()='2']")).click();
//	cd.findElement(By.xpath("//*[@id=\"ow84\"]/div[1]/div/div/div[1]/div/div[1]/div/input")).click();
//	cd.findElement(By.xpath("(//input[@placeholder='Return'])[2]")).click();
//	cd.findElement(By.xpath("//div[text()='October']/following-sibling::div[@jsname='Mgvhmd']//div[text()='5']")).click();
	cd.findElement(By.xpath("//div[@class='BLohnc q5Vmde'][1]")).click();
	cd.findElement(By.xpath("//div[@data-iso='2023-09-30']")).click();
	cd.findElement(By.xpath("//div[@data-iso='2023-10-10']")).click();
	cd.findElement(By.xpath("(//span[text()='Done'])[2]")).click();
	
	cd.findElement(By.xpath("//span[text()='Search']")).click();
	
	Thread.sleep(1000);
	List<WebElement> allList = cd.findElements(By.xpath("//h3[text()='Best departing flights']/..//descendant::div[@class='BVAVmf I11szd POX3ye']/div[contains(@class,'YMlIz FpEdX')]/span"));
	System.out.println(allList.size());
	for(WebElement list:allList) {
		System.out.println(list.getText()+"->");
	}
	
	
	
	
	
	
	
	
	
	
	
	//cd.close();
	
	}
}
