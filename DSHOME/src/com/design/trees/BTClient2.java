package com.design.trees;

import com.design.trees.bst.Node;
import com.design.utils.InputReader;

public class BTClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public void process()
	{
		BinaryTree tree=new BinaryTree(new InputReader(getClass().getResourceAsStream("/tree3.txt")));
		
		
	}
	public int maximum(Node root)
	{
		int root_val,left_val,right_val,max=Integer.MIN_VALUE;
		if(root!=null)
		{
			root_val=root.key;
			left_val=maximum(root.left);
			right_val=maximum(root.right);
			
			if(left_val>right_val)
				max=left_val;
			else
				max=-right_val;
			if(root_val>max)
				max=root_val;
		}
		return max;
	}

}
