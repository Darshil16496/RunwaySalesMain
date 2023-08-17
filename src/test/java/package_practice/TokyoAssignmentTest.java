package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokyoAssignmentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String countryName = "Belarus";
        List<WebElement> countries=cd.findElements(By.xpath("//div[contains(@class,'eVgKXR')]//span[@data-cy='country-name']"));
        for (int i=0;i<countries.size();i++){
          String a=  countries.get(i).getText();
          if (a.equalsIgnoreCase(countryName)){
              String gMedal = cd.findElement(By.xpath
                ("//span[text()='"+countryName+"']/../following-sibling::div[@title='gold'"+(i+1)+"']")).getText();
        String sMedal =cd.findElement(By.xpath
                ("//span[text()='"+countryName+"']/../following-sibling::div[@data-medal-id='silver-medals-row-"+(i+1)+"']")).getText();

        String bMedal =cd.findElement(By.xpath
                ("//span[text()='"+countryName+"']/../following-sibling::div[@data-medal-id='bronze-medals-row-"+(i+1)+"']")).getText();
        String tMedal = cd.findElement(By.xpath("//span[text()='"+countryName+"']/../following-sibling::div[@data-medal-id='total-medals-row-"+(i+1)+"']")).getText();
              System.out.println(countryName+" country ContainsMedal's ");
              System.out.println("Gold - "+gMedal+" Silver - "+sMedal+" Bronze - "+bMedal+" Total - "+tMedal);
              break;
          }
        }

        cd.close();
    }

	

}
