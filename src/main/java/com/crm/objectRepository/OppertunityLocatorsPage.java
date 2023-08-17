package com.crm.objectRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OppertunityLocatorsPage {
	//declaration 
	@FindBy(xpath = "//img[@alt='Create Opportunity...']")
	private WebElement createOpportunity;
	
	@FindBy(name = "potentialname")
	private WebElement opportunityName;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement selectOrganization;
	
	@FindBy(xpath = "//a")
	private List<WebElement> eachlink;
	
	@FindBy(id = "jscal_trigger_closingdate")
	private  WebElement closeDate;
	
	@FindBy(xpath = "(//td/div[@align='center']/input[contains(@value,'Save')])[2]")
	private WebElement saveButton;
	
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement oppertnities;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement validateOppertunities;
	

	//Initialization
	public OppertunityLocatorsPage(WebDriver cd){
		PageFactory.initElements(cd, this);
	}

	//Utiliation 
	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getSelectOrganization() {
		return selectOrganization;
	}

	public List<WebElement> getEachlink() {
		return eachlink;
	}

	public WebElement getCloseDate() {
		return closeDate;
	}
	
	public WebElement getOppertnities() {
		return oppertnities;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getValidateOppertunities() {
		return validateOppertunities;
	}

	
	//Business Libraries
	public String oppertunityAction(String oppertunity) {
		String text = oppertnities.getText();
		if(text.equalsIgnoreCase(oppertunity)) {
			return "Yes You are in "+text+" Page";
		}else {
			return "No You are in SomeOther Page";
		}
	}
	public void createOpportunity() {
		createOpportunity.click();
	}
	
	public void createOpperunity(String oppertunityName, WebDriver cd) {
		opportunityName.sendKeys(oppertunityName);
		selectOrganization.click();
//		Set<String> win = cd.getWindowHandles();
//		Iterator<String> it = win.iterator();
//		while(it.hasNext())
//		{
//			String i = it.next();
//			String title = cd.switchTo().window(i).getTitle();
//			if(title.contains("Accounts"))
//			{
//				break;
//			}
//		}
		String mainId = cd.getWindowHandle();
		Set<String> allId = cd.getWindowHandles();
		//List<WebElement> elements = cd.eachlink;
		for(String id : allId) {
			System.out.println();
			if(!(mainId.equals(id))) {
				cd.switchTo().window(id);
				break;
			}
		}
		//List<WebElement> alllinks = eachlink.size();
		for(int i=0;i<eachlink.size();i++)
		{
			String s=eachlink.get(i).getText();
			if(s.contains("amazon91"))
			{
				eachlink.get(i).click();
				break;
			}
		}
		cd.switchTo().window(mainId);	  
		closeDate.click();
		saveButton.click();
	}

	public String validateOppertunity(String potentialName) {
		String text = validateOppertunities.getText();
		if(text.contains(potentialName)) {
			return "Yes Oppertunity is Created";
		}else {
			return "Yes Oppertunity is not Created";
		}
	}
}
