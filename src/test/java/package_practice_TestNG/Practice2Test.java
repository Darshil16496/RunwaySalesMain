package package_practice_TestNG;

import org.testng.annotations.Test;

import com.crm.genericUtility.BaseClass;

public class Practice2Test extends BaseClass {
	
	@Test
	public void modifiyTest() {
		System.out.println("Test is Modified From 2");
	}
	
	@Test
	public void deleteTest() {
		System.out.println("Test is Deleted From 3");
	}


}
