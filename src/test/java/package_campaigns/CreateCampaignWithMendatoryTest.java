package package_campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.CampaignLocatorsPage;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.LoginLocatorsPage;

public class CreateCampaignWithMendatoryTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
//		Random r = new Random();
//		int num = r.nextInt(500);
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//		Properties pobj=new Properties();
//		pobj.load(fis);
//		String url = pobj.getProperty("Url");
//		String browser = pobj.getProperty("Browser");
//		String username = pobj.getProperty("Username");
//		String password = pobj.getProperty("Password");
		
		FileUtility file = new FileUtility();
		JavaUtility j = new JavaUtility();
		WebDriverUtility web= new WebDriverUtility();
		ExcelUtility excel = new ExcelUtility();
		
		

		String url = file.getDataFromProperties("Url");
		String username = file.getDataFromProperties("Username");
		String password = file.getDataFromProperties("Password");
		
		//Fetching Data From the Excel
//		FileInputStream fis2 = new FileInputStream(".\\src\\\\test\\resources\\Book1.xlsx");
//		Workbook wb = WorkbookFactory.create(fis2);
//		//Sheet sh = wb.getSheet("Campaign")
		//Launching Browser
		
		String campaignName=excel.readDatafromExcel("Campaign", 0, 0)+j.getRandomNum();
		WebDriver cd = new ChromeDriver();	
		//cd.manage().window().maximize();
		web.maximizeWindow(cd);
		//cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		web.pageLoad(cd);
		cd.get(url);
//		cd.findElement(By.name("user_name")).sendKeys(username);
//		cd.findElement(By.name("user_password")).sendKeys(password);
//		cd.findElement(By.id("submitButton")).click();
		LoginLocatorsPage llp = new LoginLocatorsPage(cd);
		llp.loginAction(username, password);
		
		//Click on More
		HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
//		WebElement more = cd.findElement(By.xpath("//a[text()='More']"));
//		more.click();
		hlp.morehover(cd);
	
		//Click on Sales Order Link
		//cd.findElement(By.linkText("Campaigns")).click();
		hlp.campaignsClick();
//		cd.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//		
//		//Passing data in Campaign Textbox
//		cd.findElement(By.name("campaignname")).sendKeys(campaignName+j.getRandomNum());
//		
//		cd.findElement(By.xpath("//input[contains(@class,'crmbutton small save')]")).click();
		
		CampaignLocatorsPage clp = new CampaignLocatorsPage(cd);
		clp.campaignAction(campaignName);
		
//		Thread.sleep(100);
		String text = clp.validateCompaign(campaignName);
		System.out.println(text);
		
		hlp.HomeActionsLogout(cd);
		cd.quit();
	}

}
