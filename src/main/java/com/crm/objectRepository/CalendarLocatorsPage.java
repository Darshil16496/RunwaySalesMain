package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericUtility.WebDriverUtility;

public class CalendarLocatorsPage extends WebDriverUtility{

	//Declaration 
	@FindBy(xpath="//a[text()='Month']")
	private WebElement month;
	
	@FindBy(xpath="//a[text()='To Dos']")
	private WebElement todosLink;
	
	@FindBy(xpath = "//td[@class='calAddButton']")
	private WebElement addButton;
	
	@FindBy(linkText="To Do")
	private WebElement toDo;
	
	@FindBy(xpath = "//input[@name='task_subject']")
	private WebElement taskSubject;
	
	@FindBy(name="task_description")
	private WebElement taskDescription;
	
	@FindBy(id="taskstatus")
	private WebElement taskStatus;
	
	@FindBy(id="taskpriority")
	private WebElement taskPriority;
	
	@FindBy(xpath="(//input[value='task_assigntype'])[2]\")")
	private WebElement taskAssignType;
	
	@FindBy(name="task_assigned_group_id")
	private WebElement taskAssignGoupId;
	
	@FindBy(id = "task_date_start")
	private WebElement startDate;
	
	@FindBy(name="todosave")
	private WebElement toDoSave;
	
	//initialization
	public CalendarLocatorsPage(WebDriver cd){
		PageFactory.initElements(cd, this);
	}
	
	//Utilization
	public WebElement getMonth() {
		return month;
	}
	
	

	public WebElement getToDo() {
		return toDo;
	}

	public WebElement getTaskSubject() {
		return taskSubject;
	}

	public WebElement getTaskDescription() {
		return taskDescription;
	}

	public WebElement getTaskStatus() {
		return taskStatus;
	}

	public WebElement getTaskPriority() {
		return taskPriority;
	}

	public WebElement getTaskAssignType() {
		return taskAssignType;
	}

	public WebElement getTaskAssignGoupId() {
		return taskAssignGoupId;
	}
	
	

	public WebElement getTodosLink() {
		return todosLink;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getToDoSave() {
		return toDoSave;
	}
	
	//Business Libraries
	
	public void monthClick(WebDriver cd) {
		
	}
	public void calendarAction(WebDriver cd, String tdname, String discription, String status, String priority, String assign, String date) {
		moveToElement(cd, month);
		month.click();
		waitForPerticularElement(cd, month);
		//moveToElement(cd, todosLink);
		todosLink.click();
		moveToElement(cd, addButton);
		toDo.click();
		taskSubject.sendKeys(tdname);
		taskDescription.sendKeys(discription);
		select(status, taskStatus);
		select(priority, taskPriority);
		select(assign, taskAssignType);
		startDate.sendKeys(date);
		toDoSave.click();
	}
	
	
}
