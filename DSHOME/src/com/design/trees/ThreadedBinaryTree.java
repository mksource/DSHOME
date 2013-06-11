package com.design.trees;
/**
 * 
 * @author karthik
 * Main Motivation for Threaded Binary Tree
 * 		a.)The traversal algorithms for the binary tree consume there time manipulating a stack
 * 		b.)The space consumed by a stack is always more
 * 		c.)Most of the nodes in the tree have there left links or right links as null
 * 		   A binary tree with n nodes will have n+1 null pointers
 * 		d.)If the right child of particular node is null and if the RNode points to the inode 
 *         successor then we will call such a right child as a thread 	
 */
public class ThreadedBinaryTree {
	
	private TNode HEAD;
	
	private static final int LINK=0;
	private static final int THREAD=1;
	
	public static final String INORDER="INORDER";
	public static final String POSTORDER="POSTORDER";
	public static final String PREORDER="PREORDER";
	
	public ThreadedBinaryTree()
	{
		//If the tree is empty then HEAD's left child will point to HEAD itself
		//otherwise will point to the root
		//The right child of the HEAD will always point to the HEAD itself.
		HEAD=new TNode();
		HEAD.RTag=THREAD;
		HEAD.RNode=HEAD;
		HEAD.LNode=HEAD;
		HEAD.LTag=THREAD;
	}
	public void doTraversal(String type)
	{
		if(type.equals(INORDER)){
			System.out.println("InOrder Traversal");
			inorder();
		}
		else if(type.equals(PREORDER)){
			preorder();
		}
		else if(type.equals(POSTORDER)){
			postorder();
		}
	}
	public TNode leftMost(TNode node)
	{
		TNode ans=node;
		if(ans==null)
			return null;
		while(ans.LNode!=HEAD)
			ans=ans.LNode;
		return ans;
	}
	public void inorder()
	{
		/*The idea is to start from the left most node, after that if
		 * a node has right child then we print the leftmost node in the right subtree
		 * otherwise we print the the right successor
		 * */
		TNode cur=leftMost(HEAD.LNode);
		
		while(cur!=HEAD)
		{
			System.out.print(cur.data+" ");
			if(cur.RTag==THREAD)
				cur=cur.RNode;
			else
				cur=leftMost(cur.RNode);
		}
		
	}
	public void preorder()
	{
		
	}
	public void postorder()
	{
		
	}
	public void insert(int element)
	{
		//Make a new Node 
		TNode newNode=new TNode();
		newNode.data=element;
		newNode.LTag=THREAD;
		newNode.RTag=THREAD;
		
		//Check if the tree is empty 
		if(HEAD.LNode==HEAD)
		{
			HEAD.LNode=newNode;
			newNode.LNode=HEAD;
			newNode.RNode=HEAD;
			return;
		}
		
		/**If the tree is not empty then we following method
		 * 	a.) We have to search for NULL pointers where insertion has to happen like in binary search tree
		 *  b.) While searching if find a Node whose right child or left child is a thread then that position
		 *      is a suitable position for insertion
		 * 
		 * **/
		 //Get the root element
		 TNode temp=HEAD.LNode;
		 
		 while(temp!=HEAD)
		 {
			 if(element<=temp.data)
			 {
				 //We have to insert the new node in the left subtree 
				 if(temp.LTag==THREAD)
				 {
					 //We have found the proper position to insert
					 newNode.LNode=temp.LNode;
					 temp.LNode=newNode;
					 newNode.RNode=temp;
					 temp.LTag=LINK;
					 break;
				 }
				 else
				 {
					 temp=temp.LNode;
				 }
			 }
			 else
			 {
				 //We have to insert the new node in the right subtree
				 if(temp.RTag==THREAD)
				 {
					 //We have found the proper position to insert 
					 newNode.LNode=temp;
					 newNode.RNode=temp.RNode;
					 temp.RNode=newNode;
					 temp.RTag=LINK;
					 break;
					 
				 }
				 else
				 {
					 temp=temp.RNode;
				 }
			 }
		 }
		
	}
}	