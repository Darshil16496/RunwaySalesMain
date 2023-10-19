package package_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TestCaptcha {

	@Test
	public void testCaptcha() throws IOException, TesseractException, InterruptedException {
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		cd.get("https://www.irctc.co.in/nget/train-search");
		cd.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
		cd.findElement(By.xpath("//input[@formcontrolname='userid']")).click();
		cd.findElement(By.xpath("//input[@formcontrolname='password']")).click();
		WebElement captcha = cd.findElement(By.xpath("//img[@class='captcha-img']"));
		File src=captcha.getScreenshotAs(OutputType.FILE);
		String Path = "C:\\Users\\SAFFRO TECHNOLOGIES\\git\\RunwaySalesMain\\ScreenShot\\img.png";
		FileHandler.copy(src, new File(Path));
		Thread.sleep(2000);
		ITesseract tess = new Tesseract();
		
		tess.setDatapath("C:\\Users\\SAFFRO TECHNOLOGIES\\Desktop\\Selenium\\Tess4J\\tessdata");
		
		String text = tess.doOCR(new File(Path));
		System.out.println(text);
		cd.findElement(By.id("captcha")).sendKeys(text);
		Thread.sleep(2000);
		cd.close();
		
		
		
		
	}
	
}
