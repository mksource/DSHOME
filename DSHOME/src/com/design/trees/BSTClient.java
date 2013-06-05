package com.design.trees;

import com.design.trees.bst.TraverseType;

public class BSTClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BinarySearchTree bst=new BinarySearchTree();
		bst.insert(15);
		bst.insert(8);
		bst.insert(9);
		bst.insert(11);
		bst.insert(26);
		bst.insert(21);
		bst.insert(22);
		bst.insert(24);
		bst.insert(28);
		bst.insert(32);
		bst.insert(7);
		bst.insert(3);
		bst.insert(12);
		
		bst.traverse(TraverseType.INORDER);

	}

}
