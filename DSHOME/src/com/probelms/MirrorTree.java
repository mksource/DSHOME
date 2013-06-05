package com.probelms;

import com.design.trees.BinaryTree;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

public class MirrorTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MirrorTree tree=new MirrorTree();
		tree.makeInput();
	}
	public void makeInput()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree3.txt"));
		BinaryTree tree=new BinaryTree(in);
		tree.inOrder(tree.getRoot());
		findMirror(tree.getRoot());
		tree.inOrder(tree.getRoot());
	}
	
	public void findMirror(Node node)
	{
		/**
		 * To Find the mirror of a tree 
		 * first find the mirror of the left subtree and mirror of the right subtree
		 * exchange the left subtree and right subtree
		 *
		 */
		if(node==null)return;
		//find the mirror of the left subtree
		findMirror(node.left);
		
		//find the mirror of the right subtree
		findMirror(node.right);
		
		//exchange the left and right subtrees
		Node temp=node.left;
		node.left=node.right;
		node.right=temp;
	}

}
