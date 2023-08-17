package package_practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KayakExampleTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		cd.get("https://www.kayak.co.in/");
		cd.findElement(By.xpath("//div[text()='Flights']")).click();
		String startMonth = "August 2023";
	    String startDate = "29";
	    String endMonth = "September 2023";
		cd.findElement(By.className("vvTc-item-button")).click();
        cd.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("bangalore");
        cd.findElement(By.xpath("//div[@class='JyN0-item JyN0-pres-item-mcfly']")).click();
        cd.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys("delhi");
        cd.findElement(By.xpath("//div[@class='JyN0-item JyN0-pres-item-mcfly']")).click();
        cd.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
        while (true) {

            try {
                cd.findElement(By.xpath("//div[.='" + startMonth + "']/../..//div[text()='" + startDate + "']")).click();
                break;
            } catch (Exception e) {
                cd.findElement(By.xpath("//div[contains(@class,'ATGJ-next-month')]//div[@class='Iqt3-button-container']")).click();
            }
        }

        cd.findElement(By.xpath("//span[@aria-label='End date calendar input']")).click();

        while (true) {
            String month = cd.findElement(By.xpath("//div[@class='wHSr-monthName']")).getText();
            if (month.equals(endMonth)) {
                cd.findElement(By.xpath("//div[.='" + endMonth + "']/../..//div[text()='15']")).click();
                break;
            } else {
                cd.findElement(By.xpath("//div[contains(@class,'ATGJ-next-month')]//div[@class='Iqt3-button-container']")).click();
            }
        }
        String mainId=cd.getWindowHandle();
        cd.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
        Set<String> allID=cd.getWindowHandles();
        for (String win:allID){
            if (!(win.equals(mainId))){
                cd.switchTo().window(win);
            }
        }
        cd.findElement(By.xpath("//div[@class='c1wE_-handle']")).click();
        cd.findElement(By.xpath("//span[text()='Slowest']")).click();
       String price=cd.findElement(By.xpath("//div[@class='yuAt yuAt-pres-rounded']//div[@class='vrqM-price']")).getText();

        price=price.replace("₹","");
        System.out.println(price);
        Integer p=0;
        try {
            p = Integer.valueOf(price);
        }catch (Exception e){

        }
       if (p<15000){
           System.out.println("price is less than 15000");
       }else {
           System.out.println("price is not less than 15000");
       }
              
    
	cd.close();
	
	}

}
