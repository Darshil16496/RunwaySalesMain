package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocatorsPage {
	//declaration
	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement passWord;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	//initialization
	public LoginLocatorsPage(WebDriver cd){
		PageFactory.initElements(cd, this);
	}
	
	//Utilization
	public WebElement getuserName() {
		return userName;
	}
	
	public WebElement getpassWord() {
		return passWord;
	}
	
	public WebElement submitButton() {
		return submitButton;
	}

	//Business Libraries
	public void loginAction(String username, String password) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		submitButton.click();
	}
	

}
