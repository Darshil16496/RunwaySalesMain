package package_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonIphoneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://www.amazon.in/");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        List<WebElement> allPhone=cd.findElements(By.xpath
                ("//div[@class='a-section']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
        List<WebElement> allPhonePrice= cd.findElements
                (By.xpath("//div[@class='a-section']//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/../following-sibling::div//span[@class='a-price-whole']"));
        for (int i=0;i<allPhone.size();i++){
            System.out.println(allPhone.get(i).getText()+"------->"+allPhonePrice.get(i).getText());
        }
        cd.close();
	}

}
