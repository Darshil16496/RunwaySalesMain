package package_practice_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationPractice {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("**** Before Suite ****");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("**** Before Class ****");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("**** Before Method ****");
	}
	
	@Test
	public void resultMethod() {
		System.out.println("The fist Test is executed");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("**** After Method ****");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("**** After Class ****");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("**** After suite****");
	}
	
	@BeforeMethod
	public void beforeMethod1() {
		System.out.println("**** Before Method ****");
	}
	
	@Test
	public void resultMethod1() {
		System.out.println("The Second Test is executed");
	}
	
	@AfterMethod
	public void afterMethod1() {
		System.out.println("**** After Method ****");
	}
}
