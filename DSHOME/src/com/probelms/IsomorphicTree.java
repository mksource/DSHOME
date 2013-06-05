package com.probelms;

import com.design.trees.BinaryTree;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;


/**
 * 
 * @author karthik1
 *  Trees are said to be isomorphic 
 *  Let n1 and n2 be the current internal nodes of the trees be traversed 
 *  These the following conditions for the subtrees rooted at n1 and n2 to be true
 *  1.) Data n1 and n2 are same 
 *  2.) one of the following are true for the children of n1 and n2
 *    a.)Left child of n1 is isomorphic to Left child of n2 and right child of n1 and right child n2
 *    b.)Left child of n1 is isomorphic to Right child of n2 and right child of n1 is isomorphic to left child of n2
 */


public class IsomorphicTree {

	
	
	
	public boolean isIsomorphic(Node root1,Node root2)
	{
		//Both trees are null trees are isomorphic be definition
		if(root1==null && root2==null)return true;
		
		//One of the trees are null so trees are not isomorphic
		else if(root1==null || root2==null)return false;
		
		//The key at nodes are not equal so trees are not isomorphic
		else if(root1.key!=root2.key)return false;
		
		
		//Case 1 the subtrees rooted at n1 and n2 are not flipped
		//Case 2 the subtrees rooted at n1 and n2 are flipped
		return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right,root2.right))|| (isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsomorphicTree iso=new IsomorphicTree();
		iso.determineIsomorphic();
		

	}
	
	public void determineIsomorphic(){
	
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree1.txt"));
		BinaryTree tree1=new BinaryTree(in);
		tree1.inOrder(tree1.getRoot());
		System.out.println("");
		in.close();
		in=new InputReader(getClass().getResourceAsStream("/tree2.txt"));
		BinaryTree tree2=new BinaryTree(in);
		tree2.inOrder(tree2.getRoot());
		System.out.println("");
		in.close();
		
		if(isIsomorphic(tree1.getRoot(),tree2.getRoot()))
			System.out.println("Trees are isomorphic");
		else 
			System.out.println("Trees are not isomorphic");
		
	}

}
