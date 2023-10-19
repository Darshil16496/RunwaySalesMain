package all97Programs;

import java.util.LinkedList;

import org.testng.annotations.Test;



public class JavaPrograms {

	@Test
	public void program1() {
		//input: wlecom to expleo                                                                                                          
		//output: expleo to welcome
		
		String s = "WelCome to Explore";
		String[] s1= s.split(" ");
		System.out.println(s1.length);
		for(int i = s1.length-1; i>=0;i--) {
			System.out.print(s1[i]+" ");
		}
	}
	
	@Test
	public void removeDuplicateFromString() {
		String s = "ManusLabuschangne;";
		for (int i = 0; i < s.length(); i++) {
			int count = 1;
			for (int j = i+1; j < s.length(); j++) {
				if(s.charAt(i)==s.charAt(j)) {
					count++;
				}
			}
			if(count == 1) {
				System.out.println(s.charAt(i));
			}
		}
	}
	
	@Test
	public void removeDuplicateWordsFromString() {
		String s = "I am working in Ty But However I am Working 8 hours";
		String s1[] = s.split(" ");
		for (int i = 0; i < s1.length; i++) {
			int count = 1;
			for (int j = i+1; j <  s1.length; j++) {
				if(s1[i]==s1[j]) {
					count++;
				}
			}
			if(count == 1) {
				System.out.println(s1[i]);
			}
		}
	}
	
	@Test
	public void program4() {
		//input: wlecom to expleo                                                                                                          
		//output: expleo to welcome
		
		String s = "Today is Friday";
		String[] s1= s.split(" ");
		System.out.println(s1.length);
		for(int i = s1.length-1; i>=0;i--) {
			System.out.print(s1[i]+" ");
		}
	}
	
	@Test
	public void addStringInMiddle() {
		String s[] = {"Today","is","Tuesday", "Working"};
		int middle = s.length/2;
		LinkedList<String> list = new LinkedList<String>();
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
		}
		
		list.add(middle, "a");
		System.out.println(list);
	}
	
	@Test
	public void reverseWordInString() {
		String s = "Today is a Working Day";
		String s1[] = s.split(" ");
		for (int i = 0; i < s1.length; i++) {
			String str = s1[i];
			//System.out.println(wordlen);
			for (int j = str.length()-1; j >= 0; j--) {
				System.out.print(str.charAt(j));
			}
			System.out.print(" ");
		}
	}
	
	
	
}
