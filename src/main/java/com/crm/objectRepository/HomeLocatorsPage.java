package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.WebDriverUtility;

public class HomeLocatorsPage extends WebDriverUtility{

	//Declaration
	@FindBy(linkText="Calendar")
	private WebElement calendar;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunities;
	
	@FindBy(linkText="Products")
	private WebElement products;
	
	@FindBy(linkText="Documents")
	private WebElement documents;
	//
	@FindBy(linkText="Email")
	private WebElement email;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTickets;
	
	@FindBy(linkText="More")
	private WebElement more;
	
	@FindBy(linkText="Sales Order")
	private WebElement salesOrder;

	
	@FindBy(linkText="Campaigns")
	private WebElement campaigns;
	
	@FindBy(linkText="Reports")
	private WebElement reports;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logout;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	
	//initialization
	public HomeLocatorsPage(WebDriver cd){
		PageFactory.initElements(cd, this);
	}

	//Utilization
	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getOpportunities() {
		return opportunities;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getDocuments() {
		return documents;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTroubleTickets() {
		return troubleTickets;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getSalesOrder() {
		return salesOrder;
	}

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getReports() {
		return reports;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	//Business Libraries 
	public void HomeActions() {
		products.click();
		documents.click();
		email.click();
		troubleTickets.click();
		more.click();
	}
	
	public void calendarClick() {
		calendar.click();
	}
	
	public void opportunitiesClick() {
		opportunities.click();
	}
	
	public void salesOrderClick(WebDriver cd) {
		moveToElement(cd, more);
		salesOrder.click();
		
	}
	
	public void morehover(WebDriver cd) {
		moveToElement(cd, more);
	}
	
	public void campaignsClick() {
		//moveToElement(cd, more);
		campaigns.click();
		
	}
	
	public void reportsClick() {
		//moveToElement(cd, more);
		reports.click();
		
	}
	
	public void HomeActionsLogout(WebDriver cd) {
		logout.click();
		moveToElement(cd, signOut);
		signOut.click();
	}

	
	
	
}
