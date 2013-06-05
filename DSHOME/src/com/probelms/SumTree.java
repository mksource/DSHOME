package com.probelms;

import com.design.trees.BinaryTree;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

public class SumTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumTree tree=new SumTree();
		tree.findSum();

	}
	
	public int sumelement(Node node)
	{
		if(node==null)return 0;
		
		//Store the old vaue of the node 
		int olddata=node.key;
		
		//Replace the node data with the sum of the left subtree and right subtree
		node.key=sumelement(node.left)+sumelement(node.right);
		
		return node.key+olddata;
	}
	
	public void findSum()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree1.txt"));
		BinaryTree tree=new BinaryTree(in);
		tree.inOrder(tree.getRoot());	
		System.out.println("");
		sumelement(tree.getRoot());
		tree.inOrder(tree.getRoot());
	}

}
