package package_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	SoftAssert s = new SoftAssert();
	@Test
	public void softAssert() {
		System.out.println("Darshil");
		System.out.println("Prajapati");
		s.assertEquals("a", "a");
		System.out.println("Abhishek");
		System.out.println("Prajapati");
		s.assertAll();
	}
}
