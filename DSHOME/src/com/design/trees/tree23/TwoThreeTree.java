package com.design.trees.tree23;

public class TwoThreeTree {

	private Node23 root;
	
	public TwoThreeTree()
	{
		root=null;
	}
	
	public void traverse()
	{
		
	}
	
	public void insert(int element)
	{
		//Find the leaf Node into which the node has to be inserted
		Node23 leafNode=findLeafNode(root,element);
		if(leafNode==null)
		{
			//case 1:If the node is null then tree is empty we have to create a new tree
			//with a 2 node
			root=Node23.createTwoNode(element);
		}
		else if(leafNode.isTwoNode())
		{
			//case 2:If the node contains only one element then we have space to insert the element
			//so make it a 3 node
			leafNode.setTwoNode(false);
			if(leafNode.getLeftValue()<element)
				leafNode.setRightValue(element);
			else
			{
				leafNode.setRightValue(leafNode.getLeftValue());
				leafNode.setLeftValue(element);
			}
			
		}
		else
		{
			//case 3:If the node is three node then we have to split 
			split(leafNode,element);
		}
		
		
		
		
	}
	public Node23 findLeafNode(Node23 node,int element)
	{
		//If it is a empty tree then return
		if(node==null)
			return null;
		//It we have reached the leaf node then return 
		if(node.isTerminal())return node;
		//Find out whether it is 2-node or 3-node and traverse accordingly
		if(node.isTwoNode())
		{
			if(element<node.getLeftValue())
				return findLeafNode(node.getLeftchild(),element);
			else
				return findLeafNode(node.getRightchild(),element);
		}
		else
		{
			if(element<node.getLeftValue())
				return findLeafNode(node.getLeftchild(),element);
			else if(element>node.getRightValue())
				return findLeafNode(node.getRightchild(),element);
			else
				return findLeafNode(node.getMiddlechild(),element);
		}
		
		
	}
	public void split(Node23 node,int element)
	{
		//First the find smallest value, middle value and largest value 
		int smallest=0,middle=0,largest=0;
		if(element<node.getLeftValue())
		{
			smallest=element;
			middle=node.getLeftValue();
			largest=node.getRightValue();
		}
		else if(element>node.getRightValue())
		{
			smallest=node.getLeftValue();
			middle=node.getRightValue();
			largest=element;
		}
		else
		{
			smallest=node.getLeftValue();
			middle=element;
			largest=node.getRightValue();
		}
		
		
		//Mark the node has to be split to indicating its parent to find two leftmost children
		//and two rightmost children
		node.setHasSplit(true);
		
		//check whether inserting the middle element into the parent makes 
		Node23 parent=node.getParent();
		if(parent==null)
		{
			//Then the node we are splitting is root we have to create new root
			parent=Node23.createTwoNode(middle);
			
		}
		else
		{
			//If the parent node is 2-node 
			if(parent.isTwoNode())
			{
				//Then insert the middle element into the parent 
				parent.insertValue(middle);
				parent.setTwoNode(false);
			}
			else
			{
				split(parent,middle);
			}
			
			//If the parent node is 3-node
		}
		
		
		//Create two nodes n1 and n2 containing the smallest and largest value  and make this left and right child of
		//parent p
		Node23 n1=Node23.createTwoNode(smallest);
		Node23 n2=Node23.createTwoNode(largest);
		
		//if the node is not terminal then we have to associate 
		if(!node.isTerminal())
		{
			
		}
		
		//associate 
		
	}
}
