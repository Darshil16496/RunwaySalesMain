package AutomationScriptApi;
import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.when;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
//import junit.framework.Assert;
import com.crm.genericUtility.DatabaseUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;




public class AutomationScriptTest{
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	DatabaseUtility dlib= new DatabaseUtility();
	@Test
	public void testScript() throws SQLException, InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver cd = new ChromeDriver();
		wLib.maximizeWindow(cd);
		cd.get("http://rmgtestingserver:8084/");
		cd.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		cd.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		cd.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		String projectName = "Kurush"+jLib.getRandomNum();
		cd.findElement(By.xpath("//a[text()='Projects']")).click();
		cd.findElement(By.xpath("//span[text()='Create Project']")).click();
		cd.findElement(By.name("projectName")).sendKeys(projectName);
		cd.findElement(By.name("createdBy")).sendKeys("Kuru",Keys.TAB,Keys.ENTER,Keys.ARROW_DOWN,Keys.ENTER);
//		cd.findElement(By.name("createdBy")).sendKeys("Kuru");
		cd.findElement(By.xpath("//input[@value='Add Project']")).click();
		WebElement ab = cd.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td"));
		String ProjectId = ab.getText();
		
		//GetProject
		baseURI = "http//rmgtestingserver:8084";
		when()
		.get("/projects/"+ProjectId).then().assertThat().statusCode(200).log().all();
		
		
		String query = "select * from project";
		String actData = dlib.executeQueryAndGetData(query, ProjectId, 1);
	//	Assert.assertEquals(ProjectId, actData);
		System.out.println("Tc Pass");
						
		//.then().log().all();
	}
	
	
}
