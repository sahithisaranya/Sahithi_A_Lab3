package com.greatlearninglab3.balancing_brackets;

public class BalancingBrackets {

	public static void main(String[] args) {
		
		//store brackets string in the variable parString
		String parString="([[{}]])";
		
		//create object to Stack class
		Stack parStack=new Stack();
		
		//call evaluateParenthesis method passing parString as argument and print message based on return status.
		if(parStack.evaluateParenthesis(parString)) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else {
			System.out.println("The entered String do not contain Balanced Brackets");
		}
	}

}
