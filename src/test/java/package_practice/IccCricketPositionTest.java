package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCricketPositionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> allPosition=cd.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[1][text()>30]"));
		List<WebElement> allName = cd.findElements(By.xpath("//span[@class='u-hide-phablet']"));
//		for(WebElement position:allPosition) {
//			
//			System.out.println(position.getText());
//		}
		System.out.println("CountryName---PlayedMatches");
		for(int i=0;i<allPosition.size();i++) {
			System.out.println(allName.get(i).getText()+"---->"+allPosition.get(i).getText());
		}
		cd.close();
		
	}

}
