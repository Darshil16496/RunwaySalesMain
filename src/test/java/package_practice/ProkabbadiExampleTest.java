package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProkabbadiExampleTest {

	public static void main(String[] args) {
			WebDriver cd = new ChromeDriver();
			cd.manage().window().maximize();
			cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			cd.get("https://www.prokabaddi.com/standings");
			String teamName="Bengaluru Bulls";
			List<WebElement> allname = cd.findElements(By.xpath("//p[@class='name']"));
			
			for(WebElement name:allname) {
				if(teamName.equalsIgnoreCase(name.getText())) {
					String info = cd.findElement(By.xpath("//p[text()='"+teamName+"']/ancestor::div[@class='row-head']")).getText();
					System.out.print(info);
				}
			}
			cd.close();
	}			

}
