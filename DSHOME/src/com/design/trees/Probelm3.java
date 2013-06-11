package com.design.trees;

import com.design.trees.bst.Node;
import com.design.utils.InputReader;

public class Probelm3 {

	public static void main(String args[])
	{
		Probelm3 p=new Probelm3();
		p.solve();
	}
	public void solve()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree5.txt"));
		BinaryTree tree=new BinaryTree(in);
		
		findAncestors(tree.getRoot(),14);
	}
	public boolean findAncestors(Node node,int target)
	{
		
	    /*We follow postorder traversal method*/
		/*base Case*/
		if(node==null)return false;
		
		/*If the target is found then return true*/
		if(node.key==target)return true;
		
		/*Find Whether the key is found in the left subtree or in the right subtree*/
		if(findAncestors(node.left,target)|| findAncestors(node.right,target))
		{
			System.out.print(node.key+" ");
			return true;
		}
	
		//Else return false
		return false;
	}
}
