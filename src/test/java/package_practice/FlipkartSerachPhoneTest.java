package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartSerachPhoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		cd.get("https://www.flipkart.com/");
		
		//cd.findElement(By.xpath("//button[text()='✕']")).click();
		cd.findElement(By.name("q")).sendKeys("Samsung",Keys.ENTER);
		List<WebElement> title=cd.findElements(By.xpath("//div[contains(@class,'rR0')]"));
		List<WebElement> price=cd.findElements(By.xpath("//div[contains(text(),'APPLE iPhone')]/../following-sibling::div[@class='col col-5-12 nlI3QM']/div/descendant::div[@class='_30jeq3 _1_WHN1']"));
		System.out.println(title.size());
		System.out.println(price.size());
		for(int i = 0; i < title.size();i++) {
			System.out.println(title.get(i).getText()+"-->"+price.get(i).getText());
		}
		cd.close();
	}

}
