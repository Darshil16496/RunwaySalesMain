package package_practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeeksForGeeks {

	
	@Test
	public void favIconclick() {
		WebDriverManager.chromedriver().setup();
		WebDriver cd= new ChromeDriver();
		cd.get("https://www.geeksforgeeks.org/java-tutorial/");
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement favIcon = cd.findElement(By.xpath("//a[.='Computer Science']"));
		Actions ac = new Actions(cd);
		ac.scrollToElement(favIcon).perform();
		cd.findElement(By.xpath("//div[@class='youtube']")).click();
		cd.findElement(By.xpath("//div[@class='twitter']")).click();
		cd.findElement(By.xpath("//div[@class='facebook']")).click();		
		cd.findElement(By.xpath("//div[@class='linkedin']")).click();
		cd.findElement(By.xpath("//div[@class='instagram']")).click();
		
		Set<String> allTab = cd.getWindowHandles();
		String mainId = cd.getWindowHandle();
		System.out.println(mainId);
	
		for(String id:allTab) {
			
			cd.switchTo().window(id);
			String title = cd.getTitle();
			if(title.contains("Instagram")) {
				cd.switchTo().window(id);	
			}else {
				cd.close();
			}
		}		
	}
}
