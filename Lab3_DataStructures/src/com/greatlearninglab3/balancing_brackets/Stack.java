package com.greatlearninglab3.balancing_brackets;

//declare a class to implement Stack data structure
//and evaluate a string of parenthesis
public class Stack {
	
	//member variables for size of stack, a char array storing stack elements and
	//integer to store current position in stack
	private int size;
	private char[] stackArr;
	private int curr_pos;
	
	//method name: initializeStack
	//arguments: a string with brackets
	//returns: nothing
	//description: initializes the stack according to length of brackets string
	private void initialiseStack(String parString) {
		size=parString.length();//sets the size of stack based on length of brackets string
		stackArr=new char[size];//dynamically allocate stack array size
		curr_pos=-1;//sets current position in stack as -1
	}
	
	//method name: push
	//arguments: a character variable
	//returns: nothing
	//description: accepts a character 'c' as argument, checks if current position is less than
	//size of stack and then pushes the character element into stack
	private void push(char c) {
		if(curr_pos<size) {
			stackArr[++curr_pos]=c;
		}
	}
	
	//method name: pop
	//arguments: none
	//returns: a character value which is popped from stack
	//description: checks if current position is >=0 and returns the top element of stack to user
	private char pop() {
		char c='x';
		if(curr_pos>=0) {
			c=stackArr[curr_pos--];
		}
		return c;
	}
	
	//method name: isFull
	//arguments: none
	//returns: a boolean value 
	//description: checks if stack is full and returns the status true or false
	private boolean isFull()
	{
		if(curr_pos>=size) {
			return true;
		}
		return false;
	}
	
	//method name: isEmpty
	//arguments: none
	//returns: a boolean value 
	//description: checks if stack is empty and returns the status true or false
	private boolean isEmpty() {
		if(curr_pos<0) {
			return true;
		}
		return false;
	}
	
	//method name: isOpenParenthesis
	//arguments: a char value
	//returns: a boolean value 
	//description: checks if char p is either one of (,{,[. If so returns true; otherwise false
	private boolean isOpenParenthesis(char p) {
		if(p=='('||p=='{'||p=='[') {
			return true;
		}
		else {
			return false;
		}
	}
	
	//method name: isCloseParenthesis
	//arguments: a char value
	//returns: a boolean value 
	//description: checks if char p is either one of ),},]. If so returns true; otherwise false
	private boolean isCloseParenthesis(char p) {
		if(p==')'||p=='}'||p==']') {
			return true;
		}
		else {
			return false;
		}
	}
	
	//method name: checkMatched
	//arguments: two char values 
	//returns: a boolean value
	//description: in this method the first argument is poppedPar and second is currPar
	//Here it is checked if for every popped bracket from stack, there is corresponding closed bracket in the string
	//if so, the method returns true, otherwise returns false.
	private boolean checkMatched(char poppedPar,char currPar) {
		if(poppedPar=='(' && currPar==')')
			return true;
		else if(poppedPar=='['&& currPar==']')
			return true;
		else if(poppedPar=='{'&& currPar=='}')
			return true;
		else return false;
	}
	
	//method name: evaluateParenthesis
	//arguments: a string value with brackets to check
	//returns: a boolean value 
	//description: returns true if parString is having balanced brackets, otherwise false.
	public boolean evaluateParenthesis(String parString) {
		
		//call initialiseStack method to create a stack
		initialiseStack(parString);
		
		boolean status=true;//create a boolean variable and assume its value true, assuming parString to
		//have balanced brackets
		
		//loop through size of parString
		for(int i=0;i<size;i++) {
			
			//get current character from the string
			char currParenthesis=parString.charAt(i);
			
			//checks if stack is not full if so
			if(!isFull()) {
				
				//check if the current character is an open parenthesis that is either of (, {, [.
				if(isOpenParenthesis(currParenthesis)) {
					//if so, push it into the stack
					push(parString.charAt(i));
				}
				
				//otherwise check if current character is a close parenthesis that is either of ),},]
				else if(isCloseParenthesis(currParenthesis)) {
					
					//if so, pop the last element from stack and store it in lastParEntry
					char lastParEntry=pop();
					
					//call the checkMatched utility to check if lastParEntry is corresponding open bracket
					//for the current bracket in currParenthesis
					if(checkMatched(lastParEntry, currParenthesis)) {//if matched then
						status=true;//set status true
					}
					else {//otherwise
						status=false;//sets status false and because one unbalanced bracket is found, no need to
						break;//check others, so break from the loop
					}
				}
			}
			
		}
		
		//if status is true and stack is empty then returns true
		if(status==true && isEmpty()) {
			return true;
		}
		
		
		//otherwise returns false
		return false;
	}
	
		
}
