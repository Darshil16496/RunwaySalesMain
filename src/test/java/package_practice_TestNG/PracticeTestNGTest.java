package package_practice_TestNG;

import org.testng.annotations.Test;

public class PracticeTestNGTest {
	@Test(priority= 2)
	public void createData() {
		System.out.println("This method is used to Create Data");
	}
	
	@Test(invocationCount=2)
	public void editData() {
		System.out.println("This method is used to Edit Data");
	}
	
	@Test(priority = 2,dependsOnMethods="createData")
	public void deleteData() {
		System.out.println("This method is used to Delete Data");
	}
}
