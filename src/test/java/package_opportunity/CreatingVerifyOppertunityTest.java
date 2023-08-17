package package_opportunity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;
import com.crm.objectRepository.HomeLocatorsPage;
import com.crm.objectRepository.LoginLocatorsPage;
import com.crm.objectRepository.OppertunityLocatorsPage;

public class CreatingVerifyOppertunityTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
				FileUtility file = new FileUtility();
				ExcelUtility excel = new ExcelUtility();
				JavaUtility j = new JavaUtility();
				WebDriverUtility web = new WebDriverUtility();
//				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
//				Properties pobj = new Properties();
//				pobj.load(fis);
//				String url = pobj.getProperty("Url");
//				String browser = pobj.getProperty("Browser");
//				String username = pobj.getProperty("Username");
//				String password = pobj.getProperty("Password");
//				
				String url = file.getDataFromProperties("Url");
				String username = file.getDataFromProperties("Username");
				String password = file.getDataFromProperties("Password");
//				FileInputStream fis2=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
//				Workbook wb=WorkbookFactory.create(fis2);
//				Sheet sh=wb.getSheet("opportunity");
//				
//				DataFormatter df=new DataFormatter();
//				String potentialName = df.formatCellValue(sh.getRow(0).getCell(0));
//				
				String potentialName = excel.readDatafromExcel("opportunity", 0, 0)+j.getRandomNum();
				//Launching Browser
				WebDriver cd = new ChromeDriver();
				
				
				//cd.manage().window().maximize();
				web.maximizeWindow(cd);
				//cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				web.pageLoad(cd);

				cd.get(url);
//				cd.findElement(By.name("user_name")).sendKeys(username);
//				cd.findElement(By.name("user_password")).sendKeys(password);
//				cd.findElement(By.id("submitButton")).click();
				LoginLocatorsPage llp = new LoginLocatorsPage(cd);	
				llp.loginAction(username, password);
				//Click on Oppertunities
				
				
				//cd.findElement(By.linkText("Opportunities")).click();
				HomeLocatorsPage hlp = new HomeLocatorsPage(cd);
				hlp.opportunitiesClick();
				
//				cd.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
				OppertunityLocatorsPage olp = new OppertunityLocatorsPage(cd);
				olp.createOpportunity();				
				//cd.findElement(By.name("potentialname")).sendKeys(potentialName);
				//cd.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				
//				Set<String> win = cd.getWindowHandles();
//				Iterator<String> it = win.iterator();
//				while(it.hasNext())
//				{
//					String i = it.next();
//					String title = cd.switchTo().window(i).getTitle();
//					if(title.contains("Accounts"))
//					{
//						break;
//					}
//				}
//				List<WebElement> elements = cd.findElements(By.xpath("//a"));
//				for(int i=0;i<elements.size();i++)
//				{
//					String s=elements.get(i).getText();
//					if(s.contains("amazon91"))
//					{
//						elements.get(i).click();
//						break;
//					}
//				}
//				  String window = cd.getWindowHandle();
//				  for(String w:cd.getWindowHandles())
//				  {
//					  cd.switchTo().window(w);
//				  }
//				cd.findElement(By.id("jscal_trigger_closingdate")).click();
				//cd.findElement(By.xpath("(//td[text()='28']/ancestor::div[@class='calendar']/descendant::td[text()='July, 2023'])[2]")).click();
				
//				cd.findElement(By.xpath("(//td/div[@align='center']/input[contains(@value,'Save')])[2]")).click();
				olp.createOpperunity(potentialName,cd);
				
				//web.logOut(cd);
				String text = olp.validateOppertunity(potentialName);
				System.out.println(text);
				hlp.HomeActionsLogout(cd);
				
				cd.close();
	}

}
