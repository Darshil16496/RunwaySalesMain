package package_practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver cd=new ChromeDriver();
		cd.manage().window().maximize();
		cd.get("https://gsrtc.in/site/");
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> listlinks = cd.findElements(By.xpath("//a"));
		System.out.println(listlinks.size());
		//Thread.sleep(1000);
		//ArrayList<String> links = new ArrayList<String>();
		for(int i = 0; i < listlinks.size();i++) {
			String eachlink = null;
			URL url = null;
			int statusCode = 0;
			
			try {
				eachlink = listlinks.get(i).getAttribute("href");
				url = new URL(eachlink);
				//Open URL Connection
				HttpURLConnection htp = (HttpURLConnection)url.openConnection();
				statusCode = htp.getResponseCode();
				//Check The StatusCode
				if(statusCode >= 400) {
					//links.add(eachlink+" "+statusCode);
					System.out.println(eachlink+" "+statusCode);
				}
				
			}
			catch(Exception e) {
				System.out.println(eachlink+" "+statusCode);
			}
		}
//		System.out.println(links);
		cd.close();
	}

}
