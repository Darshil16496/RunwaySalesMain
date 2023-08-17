package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.WebDriverUtility;

public class SalesLocatorsPage extends WebDriverUtility {
	//Declartion 
	@FindBy(name="search_text")
	private WebElement searchText;
	
	@FindBy(id = "bas_searchfield")
	private WebElement searchfield;
	
	@FindBy(xpath = "//input[@value=' Search Now ']")
	private WebElement searchNow;
	
	//Initialization 
	public SalesLocatorsPage(WebDriver cd){
		PageFactory.initElements(cd, this);
	}

	//Utilization
	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}
	
	//Business Libraries
	public void salesOrderAction(String SearchValue,String text,WebDriver cd) {
		
		searchText.sendKeys(SearchValue);
		searchfield.click();
		select(text, searchfield);
		searchNow.click();
		
	}
	
	public void ValidateSalesOrder(WebDriver cd, String SearchValue) {
		String text1 = cd.findElement(By.xpath("//table[@class='lvt small']//tr[@class='lvtColData']/td/descendant::a[text='"+SearchValue+"']")).getText();
		System.out.println(text1);
		
		if(text1.equalsIgnoreCase(SearchValue)) {
			System.out.println("Yes It is present");
		}else {
			System.out.println("Yes It is not present");
		}
	}
}
