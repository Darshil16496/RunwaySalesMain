package package_practice;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flipkart_testing {


	public static void main(String[] args) {
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://www.flipkart.com/");
		Actions a = new Actions(cd);
		WebElement ele = cd.findElement(By.xpath("//img[@alt='Electronics']"));
		a.moveToElement(ele).perform();
		WebElement lap = cd.findElement(By.xpath("//a[text()='Laptop Accessories']"));
		a.moveToElement(lap).perform();
		WebElement mouse = cd.findElement(By.xpath("//a[text()='Mouse']"));
		mouse.click();
		cd.findElement(By.xpath("//img[@alt='HP 1000 Wired Optical Mouse']")).click();
		 
		//Switch Window 
		String mainId = cd.getWindowHandle();
		
		Set<String> AllId = cd.getWindowHandles();
		
		for(String id:AllId) {
			
			if(!(mainId.equals(id))) {
				cd.switchTo().window(id);
				break;
			}
		}
			
		WebElement title = cd.findElement(By.xpath("//div[@class='aMaAEs']//h1"));
		WebDriverWait wait = new WebDriverWait(cd, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(title));
		System.out.println(title.getText());
		String ratings= cd.findElement(By.xpath("//span[@class='_2_R_DZ']/span")).getText();
		System.out.println(ratings);
		String price = cd.findElement(By.xpath("//div[@class='CEmiEU']/div/div")).getText();
		System.out.println(price);
		
		
	}}
