package com.crm.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
	
	//Launching the Chrome Browser;
	//WebDriver cd = new ChromeDriver();
	
	Actions ac;
	Select s;
	/**
	 * This Methos is used to maximize the browser
	 * @param cd
	 */
	public void maximizeWindow(WebDriver cd) {
		cd.manage().window().maximize();
	}
	
	/**
	 * This Methos is used to Wait for perticular element to load
	 * @param cd
	 */
	public void pageLoad(WebDriver cd) {
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * Explicit Wait
	 * @param cd
	 * @param element
	 */
	public void waitForPerticularElement(WebDriver cd, WebElement element) {
		WebDriverWait wait = new WebDriverWait(cd,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This Methos is used to Handle a Dropdown using or Select option using Index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This Methos is used to Handle a Dropdown using or Select option using Value attribute
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This Methos is used to Handle a Dropdown using or Select option using Visible Text
	 * @param visibleText
	 * @param element
	 */
	public void select(String visibleText, WebElement element) {
		s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	
	/**
	 * This Methos is used to Move a Mouse Pointer To Perticular Element
	 * @param cd
	 * @param element
	 */
	public void moveToElement(WebDriver cd, WebElement element) {
		ac= new Actions(cd);
		ac.moveToElement(element).click().perform();
	}
	
	/**
	 * This Method is used to Drag and Drop a Perticular Element
	 * @param cd
	 * @param drag
	 * @param drop
	 */
	public void dragAndDrop(WebDriver cd, WebElement drag, WebElement drop) {
		ac= new Actions(cd);
		ac.dragAndDrop(drag, drop).perform();
	}
	
	/**
	 * This Method is used to double Click on Perticular Element
	 * @param cd
	 * @param element
	 */
	public void doubleClick(WebDriver cd, WebElement element) {
		ac= new Actions(cd);
		ac.doubleClick(element).perform();
	}
	
	/**
	 * This Method is used to rightclick on Perticular Element	
	 * @param cd
	 * @param element
	 */
	public void rightClick(WebDriver cd, WebElement element) {
		ac= new Actions(cd);
		ac.contextClick(element).perform();
	}
	
	/**
	 * This Method is used to Enter a Key Press
	 * @param cd
	 */
	public void enterKeyPress(WebDriver cd) {
		ac = new Actions(cd);
		ac.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This Method is used to Key Press
	 * @param cd
	 * @throws Throwable
	 */
	public void enterKey(WebDriver cd) throws Throwable {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		
	}
	
	/**
	 * This Method is used to KeyRelease
	 * @param cd
	 * @throws Throwable
	 */
	public void KeyRelease(WebDriver cd) throws Throwable {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	/**
	 * This Method is used to Change Focus on Fame using Frame Index
	 * @param cd
	 * @param index
	 */
	public void switchToFrame(WebDriver cd, int index)  {
		cd.switchTo().frame(index);		
	}
	
	/**
	 * This Method is used to Change Focus on Fame using Frame Name
	 * @param cd
	 * @param name
	 */
	public void switchToFrame(WebDriver cd, String name)  {
		cd.switchTo().frame(name);		
	}
	
	/**
	 * This Method is used to Change Focus on Fame using Frame Id
	 * @param id
	 * @param cd
	 */
	public void switchToFrame(String id, WebDriver cd)  {
		cd.switchTo().frame(id);		
	}
	
	/**
	 * This Method is used to Change Focus on Fame using Frame Element
	 * @param cd
	 * @param element
	 */
	public void switchToFrame(WebDriver cd, WebElement element)  {
		cd.switchTo().frame(element);		
	}
	
	/**
	 * This Method is used to click on ok button of Alert Popup
	 * @param cd
	 */
	public void alertAccept(WebDriver cd) {
		cd.switchTo().alert().accept();
	}
	
	/**
	 * This Method is used to click on ok Cancel of Alert Popup
	 * @param cd
	 */
	public void alertDismiss(WebDriver cd) {
		cd.switchTo().alert().dismiss();
	}
	
	/**
	 * This Method is used to Pass String in textbox of Alert Popup
	 * @param cd
	 * @param text
	 */
	public void alertSendKeys(WebDriver cd, String text) {
		cd.switchTo().alert().sendKeys(text);;
	}
	
	/**
	 * This Method is used to get text of Alert Popup
	 * @param cd
	 * @return
	 */
	public String alertGetText(WebDriver cd) {
		String value = cd.switchTo().alert().getText();
		return value;
	}
	
	/**
	 * This method is used to scroll to on perticular Element 	
	 * @param cd
	 * @param element plural
	 */
	public void scrollToElement(WebDriver cd, WebElement element) {
		Actions ac= new Actions(cd);
		ac.scrollToElement(element);
	}
	
	/**
	 * This method is used tp scroll By Amount
	 * @param cd
	 * @param x
	 * @param y
	 */
	public void scrollByAmount(WebDriver cd, int x, int y) {
		Actions ac= new Actions(cd);
		ac.scrollByAmount(x, y);
	}
	
	/**
	 * This Method is used to Switch between two window
	 * @param cd
	 * @param partialtitle
	 */
	public void switchToWindow(WebDriver cd, String partialtitle ) {
		Set<String> windows = cd.getWindowHandles();
		
		Iterator<String> iterator = windows.iterator();
		
		while(iterator.hasNext()) {
			String winId = iterator.next();
			String currentWindowTitle =  cd.switchTo().window(winId).getTitle();
			
			if(currentWindowTitle.contains(partialtitle)) {
				break;
			}			
		}
	}
	
//	public void switchBackToParent(WebDriver cd, String id){
////		 for(String w:cd.getWindowHandles())
////				  {
//					  cd.switchTo().window(id);
////				  }
//	}
	
	/**
	 * This Method is used to ScrollByAction using JavaScript
	 * @param cd
	 */
	public void scrollBarActions(WebDriver cd) {
		JavascriptExecutor jse=(JavascriptExecutor)cd;
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	
	/**
	 * This Method is used to ScrollByAction on Perticulor Element	
	 * @param cd
	 * @param element
	 */
	public void scrollBarActions(WebDriver cd, WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)cd;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void logOut(WebDriver cd) {
		WebElement logout = cd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//ac.moveToElement(logout);
		moveToElement(cd, logout);
		cd.findElement(By.linkText("Sign Out")).click();		
	}
	
}
