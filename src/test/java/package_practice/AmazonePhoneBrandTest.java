package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonePhoneBrandTest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();	
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		cd.get("https://www.amazon.in/");
		cd.findElement(By.id("twotabsearchtextbox")).sendKeys("phones",Keys.ENTER);
		//cd.findElement(By.id("nav-search-submit-button")).click();
		
		cd.findElement(By.xpath("//span[text()='realme']")).click();
		
		//List<WebElement> titles = cd.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
		List<WebElement> titles = cd.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));
		List<WebElement> prices = cd.findElements(By.cssSelector(".a-price-whole"));
		System.out.println(titles.size());
		System.out.println(prices.size());
		for(int i = 0; i < titles.size();i++) {
			System.out.println(titles.get(i).getText()+"-->"+prices.get(i).getText());
		}
		
		cd.close();
		
	}

}
