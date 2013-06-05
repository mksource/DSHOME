package com.probelms;

import com.design.trees.BinaryTree;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

/**
 * 
 * @author karthik1
 * The probelm is to rearrange a ordered binary tree as  doubly linked list
 * The "small" pointer should play the role of the "previous" pointer
 * The "large" pointer should play the role of the "next" pointer
 * The nodes should be arranged in the inorder traversal of the tree
 */

/**
 * 1 If the left subtree exists then process the left subtree
 * 		a. Recursively convert the left subtree to DLL
 * 		b. Then find the inorder predecessor of the root in the left subtree (it is the rightmost
 *         node in the left subtree)
 *      c. Make the inorder predecessor as the prev of the root and root as next of the inorder predecessor   
 * 2 If the right subtree exists then process the right subtree
 *     a. Recursively convert the right subtree to DLL
 *     b. Then find the inorder successor of the root in the right subtree (it is the leftmost node
 *        in the right subtree)
 *     c. Make the inorder successor as the next of root and root as prev of the inorder successor
 * 3 Find the leftmost node in the left subtree and return as the head of the DLL           
 *
 */
public class TreeRecursionProbelm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeRecursionProbelm probelm=new TreeRecursionProbelm();	
	}
	public void process()
	{
		//Construct a binary tree
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree3.txt"));
		BinaryTree tree=new BinaryTree(in);
		
		
	}
	public Node btree2dll(Node root)
	{
		if(root==null)
			return root;
		root=b2dllUtil(root);
		while(root.left!=null)
			root=root.left;
		return root;
	}
	public Node b2dllUtil(Node root)
	{
		//base case
		if(root==null)
			return root;
		
		//Process the left subtree
		if(root.left!=null)
		{
			//Recursively process left subtree 
			Node left=b2dllUtil(root.left);
			
			//Find the inorder predecessor after this loop left will point to inorder predecessor
			for(;left.right!=null;left=left.right);
			
			//Inorder predecessor next is root
			left.right=root;
			
			//root prev is Inorder predecessor is left
			root.left=left;
			
			
			
		}
		//Process the right subtree
		if(root.right!=null)
		{
			//Recursively process the right subtree
			Node right=b2dllUtil(root.right);
			
			//Find the inorder predecessor after this loop right will point to inorder successor
			for(;right.left!=null;right=right.left);
			
			//Inorder successor prev will be root
			right.left=root;
			
			//root next will be Inorder Successor 
			root.right=right;
		}
		return root;
	}
	

}
