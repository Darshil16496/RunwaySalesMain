package com.crm.objectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.JavaUtility;

public class CampaignLocatorsPage extends JavaUtility{
	//Declartion
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaign;
	
	@FindBy(name = "campaignname")
	private WebElement CampaignName;
	
	@FindBy(xpath = "//input[contains(@class,'crmbutton small save')]")
	private WebElement save;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement validateCampaigns;
	
	//Initialization 
	public CampaignLocatorsPage(WebDriver cd){
		PageFactory.initElements(cd, this);
	}
	
	//Utilization
	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getCampaignName() {
		return CampaignName;
	}
		
	public WebElement getSave() {
		return save;
	}
	
	public WebElement getValidateCampaigns() {
		return validateCampaigns;
	}

	//Business Libraries
	public void campaignAction(String  campaignName) {
		createCampaign.click();
		CampaignName.sendKeys(campaignName);
		save.click();
	}
	
	public String validateCompaign(String campaignName) {
		String validate = validateCampaigns.getText();
		if(validate.equalsIgnoreCase(campaignName)) {
			return "Campaign is Created";
		}
		else {
			return "Campaign is not Created";
		}
//		assertEquals(campaignName, validate);
//		return "Campaign is Created ";
	}

	
	
}
