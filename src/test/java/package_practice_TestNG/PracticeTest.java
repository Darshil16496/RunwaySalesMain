package package_practice_TestNG;

import org.testng.annotations.Test;

public class PracticeTest {
	
	@Test(groups = "smoke")
	public void createTest() {
		System.out.println("Test Is Created");
	}
	
	@Test(groups = "regression")
	public void modifiyTest() {
		System.out.println("Test is Modified ");
	}

}
