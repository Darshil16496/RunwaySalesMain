package package_practice_TestNG;

import org.testng.annotations.Test;

public class ProductTest {

	@Test
	public void modifiyTest() {
		System.out.println("Test is Modified From 2");
	}
	
	@Test
	public void deleteTest() {
		System.out.println("Test is Deleted From 3");
	}
}
