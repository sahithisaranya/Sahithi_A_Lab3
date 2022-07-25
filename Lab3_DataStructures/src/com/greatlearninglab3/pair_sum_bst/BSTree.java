package com.greatlearninglab3.pair_sum_bst;

import java.util.Vector;

//class declaration for binary tree node
class BNode{
	//member variables declared to store key value of a node and its left and right children
	int data;
	BNode left;
	BNode right;
	
	//creates a new node with default constructor
	BNode(int d){
		this.data=d;
		this.left=null;
		this.right=null;
	}
}

//class declaration for Binary search tree implementation
public class BSTree {
	BNode root;//root node of the tree
	
	//constructor starts with empty tree
	BSTree(){
		root=null;
	}
	
	//method name: insertNodeUtil
	//parameters: a binary node and value to insert into the tree
	//returns: a binary node
	//description: inserts a node into the binary search tree
	private BNode insertNodeUtil(BNode currNode,int val) {	
		
		//check if current node is null, if so 
		//creates a new node and returns it
		if(currNode==null) {		
			currNode=new BNode(val);
			return currNode;
		}
		
		//checks if value 'val' is less than current node's data; if so calls the
		//method recursively traversing to left of binary tree
		if(val<currNode.data) {
			currNode.left=insertNodeUtil(currNode.left, val);
		}
		
		//other wise cheks if value 'val' is greater than current node's data; if so calls the
		//method recursively traversing to right of binary tree
		else if(val>currNode.data) {
			currNode.right=insertNodeUtil(currNode.right, val);
		}
				
		//returns the current node
		return currNode;	
	}
	
	
	//method name: insertToBST
	//parameters: an integer holding value to be inserted to binary tree
	//returns: nothing
	//description: considers value to be inserted into the binary tree
	//and calls the utility method insertNodeUtil
	void insertToBST(int val) {
		root=insertNodeUtil(root,val);
	}
	
	//private member variables to check if pair matching sum is found and
	//integer to check count of pairs that match the target sum
	private boolean pairStatus;
	private int count=0;

	//method name: checkPairSum
	//arguments: a binary node, an integer with target sum value and a vector holding left side child nodes of tree
	//returns: nothing
	//description: checks if any pair of nodes are having values that can add up to given target sum and displays 
	//the result accordingly
	private void checkPairSum(BNode currNode,int targetSum,Vector<Integer> v) {
				
		//checks if current node is not null
		if(currNode!=null) {
			//if so traverse towards left side of binary tree
			checkPairSum(currNode.left,targetSum,v);
			//checks if vector, v is having a value that equals difference of targetSum and currNode.data
			if(v.contains(targetSum-currNode.data)) {
				
				//if so set pairStatus as true and increment count
				pairStatus=true;
				count++;
				
				//if count is 1 then first pair is found, display the following message
				if(count==1) {
					System.out.print("The pair of nodes matching the target sum is: ");
				}
				//if second pair is found then display the following messages before printing the pair
				else if(count==2) {
					System.out.println();
					System.out.println("Other alternative pairs with target sum are: ");
				}
					
				//print the pair which has sum equal to target sum to output console
				System.out.println("("+(targetSum-currNode.data)+", "+currNode.data+")");
			}
			
			//otherwise just add the the current node's data to the vector
			v.add(currNode.data);
			
			//traverse towards right side of binary tree
			checkPairSum(currNode.right,targetSum,v);
		}
	}
	
	
	//method name: findPairSum
	//arguments: an integer with target sum value
	//returns: nothing
	//description: accepts target sum from user, calls the checkPairSum utility method to check for suitable pair
	void findPairSum(int targetSum) {
		pairStatus=false;
		Vector<Integer> v=new Vector<Integer>();
		checkPairSum(this.root,targetSum,v);
		if(!pairStatus)
			System.out.println("Nodes not found");
	}
}
