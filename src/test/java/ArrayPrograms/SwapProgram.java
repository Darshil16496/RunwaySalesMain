package ArrayPrograms;

import org.testng.annotations.Test;

public class SwapProgram {
	
//	public static void main(String[] args) {
//		int a = 10;
//		int b = 2;
//		SwapProgram sp = new SwapProgram();
//		sp.SwapUsing3Ver(a, b);
//		sp.SwapUsing2ver(a,b);
//	
//	}
	@Test
	public void SwapUsing3Ver(int a, int b) {
		int c= a+b;
		a = c-a;
		b = c- b;
		System.out.println("The value of A is:- "+a);
		System.out.println("The value of B is:- "+b);
	}
	
	@Test
	public void SwapUsing2ver(int a, int b) {
		a = a+b;
		b = a - b;
		a = a-b;
		System.out.println("The value of A is:- "+a);
		System.out.println("The value of B is:- "+b);
	}
	
	public void sortarrayUsingBubbleSort() {
		int[] a = {5,5,7,8,9};
		int len = a.length;  
        int temp = 0;  
         for(int i=0; i < len; i++){  
                 for(int j=1; j < (len-i); j++){  
                          if(a[j-1] > a[j]){  
                                 //swap elements  
                                 temp = a[j-1];  
                                 a[j-1] = a[j];  
                                 a[j] = temp;  
                         }  
                          
                 }  
                 System.out.println(a);
         }  
	}

}
