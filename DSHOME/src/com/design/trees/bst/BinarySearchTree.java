package com.design.trees.bst;

public class BinarySearchTree {

	private Node root;
	
	public Node getRoot()
	{
		return root;
	}
	
	public void insert(int element)
	{
		//Create a new Node
		Node newNode=new Node();
		newNode.key=element;
		newNode.left=null;
		newNode.right=null;
		
		if(root==null)
		{
			root=newNode;
		}
		else
		{
			Node cur=root;
			Node parent=root;
			boolean isLeftChild=false;
			
			while(cur!=null)
			{
				if(element<cur.key)
				{
					parent=cur;
					isLeftChild=true;
					cur=cur.left;
				}
				else
				{
					parent=cur;
					isLeftChild=false;
					cur=cur.right;
				}
			}
			if(isLeftChild)
			{
				parent.left=newNode;
			}
			else
			{
				parent.right=newNode;
			}
		}
		
		
		
	}
	public void delete(int element)
	{
		/**
		 * Search the tree to find whether element is found or not 
		 * IF
		 *   element is not found then return cannot delete
		 * ELSE
		 * 	 element is found
		 *   case 1: The node to be deleted is a leaf node then delete the node 
		 *           no steps required
		 *   case 2:The node to be deleted has one children, then link the child of 
		 *          node to be deleted to the parent of the node to be deleted
		 *   case 3:The node to be deleted has two children, Find the inorder successor 
		 *   		of the node to be deleted and replace it with the node to be deleted                  	  
		 * 
		 */
		Node cur=root;
		Node parent=null;
		boolean isLeftChild=false;
		
		while(cur!=null && cur.key!=element)
		{
			parent=cur;
			if(element<cur.key){
				cur=cur.left;
				isLeftChild=true;
			}	
			else{
				cur=cur.right;
				isLeftChild=false;
			}	
			
		}
		if(cur==null)
		{
			System.out.println("Element not found");
		}
		else
		{
			//Case 1:
			if(cur.left==null && cur.right==null)
			{
				if(isLeftChild)
				{
					parent.left=null;
				}
				else
				{
					parent.right=null;
				}
			}
			
			//Case 2:
			else if((cur.left!=null && cur.right==null)||(cur.left==null && cur.right!=null))
			{
				if(isLeftChild)
				{
					parent.left=cur.left;
				}
				else
				{
					parent.right=cur.right;
				}
			}
			//Case 3:
			else
			{
				//Find the Inorder successor of the node to be deleted 
				//It is the leftmost node in the right subtree of the node to be deleted 
				Node right=cur.right;
				Node succ=right;
				Node succ_parent=succ;
				while(succ.left!=null)
				{
					succ_parent=succ;
					succ=succ.left;
				}
				
				//If the successor has right subtree then we have to move up to its parent
				if(succ.right!=null)
				{
					succ_parent.left=succ.right;
				}
				//Find out whether the node to be deleted is root or not 
				//If it is root 
				if(cur==root)
				{
					root=succ;
				}
				else
				{
					if(isLeftChild)
					{
						parent.left=succ;
					}
					else
					{
						parent.right=succ;
					}
				}
			}
				
		}
		
	}
	public boolean searchElement(int element)
	{
		return search(root,element);
	}
	public boolean search(Node node,int element)
	{
		if(node==null)return false;
		else if(node.key==element) return true;
		else
		{
			if(element<node.key)return search(node.left,element);
			else return search(node.right,element);
		}
	}
	public int findminimum()
	{
		Node cur=root;
		while(cur.left!=null)
		{
			cur=cur.left;
		}
		return cur.key;
	}
	public int findMaximum()
	{
		Node cur=root;
		while(cur.right!=null)
		{
			cur=cur.right;
		}
		return cur.key;
	}
	public void traverse(TraverseType type)
	{
		if(type.equals(TraverseType.INORDER))
		{
			InOrder(root);
		}
		else if(type.equals(TraverseType.POSTORDER))
		{
			PostOrder(root);
		}
		else
		{
			PreOrder(root);
		}
	}
	private void InOrder(Node node)
	{
		if(node==null)return;
		InOrder(node.left);
		System.out.print(node.key+" ");
		InOrder(node.right);
	}
	private void PostOrder(Node node)
	{
		if(node==null)return;
		PostOrder(node.left);
		PostOrder(node.right);
		System.out.println(node.key+" ");
		
	}
	private void PreOrder(Node node)
	{
		if(node==null)return;
		System.out.println(node.key+" ");
		PreOrder(node.left);
		PreOrder(node.right);
	}
}
