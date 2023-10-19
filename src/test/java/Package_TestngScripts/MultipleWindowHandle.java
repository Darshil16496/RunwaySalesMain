package Package_TestngScripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandle {
	@Test
	public void multipleWindow() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver cd= new ChromeDriver();
		//cd.get("https://www.flipkart.com/");
		cd.switchTo().newWindow(WindowType.TAB);
		cd.get("https://www.flipkart.com/");
		cd.switchTo().newWindow(WindowType.TAB);
		cd.switchTo().newWindow(WindowType.TAB);
		cd.switchTo().newWindow(WindowType.TAB);
		cd.switchTo().newWindow(WindowType.TAB);
		cd.switchTo().newWindow(WindowType.TAB);
		cd.switchTo().newWindow(WindowType.TAB);
		cd.switchTo().newWindow(WindowType.TAB);
		cd.get("https://www.amazon.in/");

		ArrayList<String> tabs = new ArrayList<>(cd.getWindowHandles());
		System.out.println(tabs.size());
        cd.switchTo().window(tabs.get(tabs.size() - 1));
              
        Thread.sleep(5000);
        cd.switchTo().window(tabs.get(0));
   
        
	}
}
