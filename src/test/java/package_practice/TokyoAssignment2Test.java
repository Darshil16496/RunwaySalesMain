package package_practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokyoAssignment2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd= new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
	}

}
