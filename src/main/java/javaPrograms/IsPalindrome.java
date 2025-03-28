package javaPrograms;

public class IsPalindrome {
	
	public boolean isPalindrome(String str) {
		
		str = str.toLowerCase();
		
		String reversed = "";
		
		char[] ch = str.toCharArray();
		
		int start = 0;
		int end = str.length()-1;		
		
		for(int i=end; i>=start; i--) {
			
			reversed += ch[i];
			
		}
		
		return str.equals(reversed);
		
	}

}
