package package_calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.CalendarLocatorsPage;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.LoginLocatorsPage;

public class CreateCalenderToDoTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileUtility file = new FileUtility();
		JavaUtility j = new JavaUtility();
		WebDriverUtility web= new WebDriverUtility();
		ExcelUtility excel = new ExcelUtility();
//		Random r = new Random();
//		int num = r.nextInt(500);
		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url = pobj.getProperty("Url");
//		String browser = pobj.getProperty("Browser");
//		String username = pobj.getProperty("Username");
//		String password = pobj.getProperty("Password");
		
		String url = file.getDataFromProperties("Url");
		String username = file.getDataFromProperties("Username");
		String password = file.getDataFromProperties("Password");
		
		
		WebDriver cd = new FirefoxDriver();	
		
//		cd.manage().window().maximize();
		web.maximizeWindow(cd);
		
//		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		web.pageLoad(cd);

		cd.get(url);
//		cd.findElement(By.name("user_name")).sendKeys(username);
//		cd.findElement(By.name("user_password")).sendKeys(password);
//		cd.findElement(By.id("submitButton")).click();
		
		LoginLocatorsPage llp = new LoginLocatorsPage(cd);
		llp.loginAction(username, password);
		
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
		hlp.calendarClick();
		
		//Click on Calender Module
		//cd.findElement(By.linkText("Calendar")).click();
		
		//Click On Month Tab
		//cd.findElement(By.xpath("//a[text()='Month']")).click();
		//cd.findElement(By.linkText("To Dos")).click();
		
		//Click Add Button
		//WebElement calAddButton = cd.findElement(By.xpath("//td[@class='calAddButton']"));
		//Actions ac = new Actions(cd);
		//ac.moveToElement(calAddButton).perform();
		//web.moveToElement(cd, calAddButton);
		//cd.findElement(By.linkText("To Do")).click();
		
		//Get All Data From the Excel Sheet
//		FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
//		Workbook wb=WorkbookFactory.create(fis2);
//		Sheet sh=wb.getSheet("Calendar");
//		DataFormatter df=new DataFormatter();
		String tdname=excel.readDatafromExcel("Calendar", 0, 0)+j.getRandomNum();
		//System.out.println(tdname);
		String description=excel.readDatafromExcel("Calendar", 1, 0);
		String status=excel.readDatafromExcel("Calendar", 2, 0);
		String priority=excel.readDatafromExcel("Calendar", 3, 0);
		String assign=excel.readDatafromExcel("Calendar", 4, 0);
	//cd.close();
//		String tdname = df.formatCellValue(sh.getRow(0).getCell(0));
//		String description = df.formatCellValue(sh.getRow(1).getCell(0));
//		String status = df.formatCellValue(sh.getRow(2).getCell(0));
//		String priority = df.formatCellValue(sh.getRow(3).getCell(0));
//		String assign = df.formatCellValue(sh.getRow(4).getCell(0));
//		
		
//		cd.findElement(By.name("task_subject")).sendKeys(tdname);
//		cd.findElement(By.name("task_description")).sendKeys(description);
		
		//Select Task Status
		//WebElement taskStatus = cd.findElement(By.id("taskstatus"));
//		Select s = new Select(taskStatus);
//		s.selectByVisibleText(status);
		//web.select(status, taskStatus);
		
		//Select Task Priority
		//WebElement taskPriority = cd.findElement(By.id("taskpriority"));
//		Select s1 = new Select(taskPriority);
//		s1.selectByVisibleText(priority);
		//web.select(priority, taskPriority);
		
		//Select Assign To
//		cd.findElement(By.xpath("(//input[value='task_assigntype'])[2]")).click();
//		WebElement assignTo = cd.findElement(By.name("task_assigned_group_id"));
//		Select s2 = new Select(assignTo);
//		s2.selectByVisibleText(assign);
	//	web.select(assign, assignTo);
		
		//Select Starting Hours
//		WebElement starthr = cd.findElement(By.id("starthr"));
//		starthr.click();
//		Select s3 = new Select(starthr);
//		s3.selectByVisibleText("06");
		
		//Select AM or PM
//		WebElement startfmt = cd.findElement(By.id("startfmt"));
//		Select s4 = new Select(startfmt);
//		s4.selectByVisibleText("PM");
		
		//Select Start Date
		
		//WebElement startDate = cd.findElement(By.id("(//img[@id='jscal_trigger_task_date_start'])[1]"));
//		Actions ac = new Actions(cd);
//		ac.moveToElement(startDate).click().perform();
//		WebElement startDate = cd.findElement(By.id("task_date_start"));
//		startDate.clear();
//		startDate.sendKeys("2023-08-01");
		
		//Select End Date
		//WebElement dueDate=cd.findElement(By.name("task_due_date"));
		//dueDate.clear();
//		dueDate.sendKeys("2023-08-01");
		
		//Click on Save Button
		//cd.findElement(By.name("todosave")).click();
		CalendarLocatorsPage clp = new CalendarLocatorsPage(cd);
		String date = "2023-08-01";
		clp.calendarAction(cd, tdname, description, status, priority, assign, date);
		Thread.sleep(3000);
		
		hlp.HomeActionsLogout(cd);
		
//		WebElement logout = cd.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		//ac.moveToElement(logout);
//		web.moveToElement(cd, logout);
//		cd.findElement(By.linkText("Sign Out")).click();		
		
		cd.close();
	}

}
