package package_practice;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void hardAssert() throws InterruptedException {
//		System.out.println("Darshil");
//		System.out.println("Prajapati");
//		assertEquals("a", "a");
//		System.out.println("Abhishek");
//		System.out.println("Prajapati");
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https:\\www.amazon.in");
		//Thread.sleep(1000);
		 String title = cd.getTitle();
		 String exp = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in//";
		 assertEquals(title,exp);
		 System.out.println("Both Title Expected "+exp+" & actual is "+title+" Same");
	}
}
