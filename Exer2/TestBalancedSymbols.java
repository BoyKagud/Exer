package main;

/**
 * 
 * Author: Ricardo Emmanuel M. Benitez
 * 
 */

import java.util.Scanner;

public class TestBalancedSymbols {

	public static void main(String[] args) {
		int cont = 1;
		char k = 's';
		if(k != 's') System.out.println(23984);
		do {
			Scanner in = new Scanner(System.in);
			String bal = in.next();
			char[] balChars = bal.toCharArray();
					
			if(isBalanced(balChars)) System.out.println("\nBalanced");
			else System.out.println("Unbalanced");
			
			System.out.print("Try Again? (1)yes or (0)no : ");
			cont = in.nextInt();
		} while (cont==1);
	}
	
	private static boolean isBalanced(char[] chars) {
		Queue opens = new Queue();
		Stack closes = new Stack();
		
		boolean balanced = true;
		for(int k=0 ; k<chars.length ; k++) {
			char close = 0;
			if(chars[k] == '{' || chars[k] == '[' || chars[k] == '('  ) {
				opens.enqueue(chars[k]);
			}
			
			if(chars[k] == '}' || chars[k] == ']' || chars[k] == ')' ) {
				closes.push(chars[k]);
			}
		}
		if(opens.getSize() == closes.getSize()) {
			int size = opens.getSize();
			for(int itr = 1 ; itr <= size ; itr++) {				
				char close = 0;
				switch((char) opens.frontItem()) {
					case '{': close = '}'; break;
					case '[': close = ']'; break;
					case '(': close = ')'; break;
				}
								
				if(close == (char)closes.top()) {
					opens.dequeue();
					closes.pop();
				} else balanced = false;
			}
			
		} else balanced = false;
		
		
		if(balanced && opens.isEmpty() && closes.isEmpty()) return true;
		return false;
		
	}
	

}
