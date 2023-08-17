package com.crm.objectRepository;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampaignPage {
	//Declaration
	@FindBy(xpath = "//table[@class='small']//descendant::td[@class='moduleName']")
	private WebElement campaignPage;
	
	//initialization
	public ValidateCampaignPage(WebDriver cd) {
		PageFactory.initElements(cd, this);
	}

	//Utilization
	public WebElement getCampaignPage() {
		return campaignPage;
	}
	
	//Business Libraries
	public String CampaignAction(String campaign) {
		String text = campaignPage.getText();
		if(text.equalsIgnoreCase(campaign)) {
			return "Yes You are in CampaignModule";
		}else {
			return "No You are in SomeOther Page";
		}
//		assertEquals(text, campaign);
//		return "Yes You are in CampaignModule";
	}
	
	
	
}
