package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCricketExampleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		//List<WebElement> alldata = cd.findElements(By.xpath("//table//tr[*][2]"));
		
		
		List<WebElement> allNumber = cd.findElements(By.xpath("//span[@class='u-hide-phablet']//ancestor::tr//td[contains(@class,'--pos')]"));
		
		List<WebElement> allTeam = cd.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		List<WebElement> allMatches = cd.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[1]"));
		List<WebElement> allPoints = cd.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[2]"));
		List<WebElement> allRatings = cd.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[3]"));
		
		for(int i = 0; i< allNumber.size();i++) {
			System.out.println(allNumber.get(i).getText()+"--"+allTeam.get(i).getText()+"--"+allMatches.get(i).getText()+"--"+allPoints.get(i).getText()+"--"+allRatings.get(i).getText());
		}
		
//		for(WebElement data:alldata) {
//			System.out.println(data.getText());
//		}
		
		
		
		cd.close();
			
	}

}
