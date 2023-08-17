package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCricketGreaterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd =  new ChromeDriver();;
		IccCricketGreaterTest pgt = new  IccCricketGreaterTest();
		pgt.lunchApplication(cd);
		pgt.printAllData(cd);
		cd.close();
	}
	
	public void printAllData(WebDriver cd) {
		// TODO Auto-generated method stub
		List<WebElement> allGreater = cd.findElements(By.xpath("(//table//tr[*]//td[*]/..)[position()<11]"));
		for(WebElement all:allGreater) {
				System.out.println(all.getText());
		}
	}

	public void lunchApplication(WebDriver cd) {
		// TODO Auto-generated method stub
		
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	}

	
	

}
