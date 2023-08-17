package package_practice_TestNG;

import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;

public class Practice1Test extends BaseClass {
	@Test
	public void createTest() {
		System.out.println("Test Is Created from 1");
	}
	
	@Test
	public void modifiyTest() {
		System.out.println("Test is Modified From 1");
	}

	@Test
	public void deleteTest() {
		System.out.println("Test is Deleted From 1");
	}

}
