package com.greatlearninglab3.pair_sum_bst;

public class PairSum {

	public static void main(String[] args) {
		
		//create an object bst to class BSTree
		BSTree bst=new BSTree();
		
		//create an array and fill with the following values
		int arr[]= {40,20,60,10,30,50,70};
				
		//traverse through the array and insert each element from array into binary search tree
		for(int i=0;i<arr.length;i++) {
			bst.insertToBST(arr[i]);
		}
			
		//call method findPairSum passing the value of target sum as argument and check if 
		//a pair is present in the binary search tree, whose sum equals the target sum
		bst.findPairSum(130);
		
	}

}
