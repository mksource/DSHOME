package com.design.trees.tree23;

public class Node23 {

	//pointer to parent of the node 
	private Node23 parent;
	
	//pointer to the left child, middle child and right child
	private Node23 leftchild;
	private Node23 middlechild;
	private Node23 rightchild;
	
	public static Node23 createTwoNode(int leftvalue)
	{
		Node23 node=new Node23();
		node.setLeftValue(leftvalue);
		node.setTwoNode(true);
		return node;
	} 
	public static Node23 createThreeNode(int leftvalue,int rightvalue)
	{
		Node23 node=new Node23();
		node.setLeftValue(leftvalue);
		node.setRightValue(rightvalue);
		node.setTwoNode(false);
		return node;
	}
	
	public void insertValue(int value)
	{
		if(leftValue>value)
		{
			rightValue=leftValue;
			leftValue=value;
			
		}
		else
			rightValue=value;
	}
	
	private int leftValue;
	private int rightValue;
	
	public boolean isTerminal()
	{
		return (leftchild==null)&&(rightchild==null);
	}
	
	public int getLeftValue() {
		return leftValue;
	}

	public void setLeftValue(int leftValue) {
		this.leftValue = leftValue;
	}

	public int getRightValue() {
		return rightValue;
	}

	public void setRightValue(int rightValue) {
		this.rightValue = rightValue;
	}

	//tells whether node is 2-3 or not
	private boolean twoNode;
	
	//tells whether this node has to be split 
	private boolean hasSplit;

	public Node23 getParent() {
		return parent;
	}

	public void setParent(Node23 parent) {
		this.parent = parent;
	}

	public Node23 getLeftchild() {
		return leftchild;
	}

	public void setLeftchild(Node23 leftchild) {
		this.leftchild = leftchild;
	}

	public Node23 getMiddlechild() {
		return middlechild;
	}

	public void setMiddlechild(Node23 middlechild) {
		this.middlechild = middlechild;
	}

	public Node23 getRightchild() {
		return rightchild;
	}

	public void setRightchild(Node23 rightchild) {
		this.rightchild = rightchild;
	}

	public boolean isTwoNode() {
		return twoNode;
	}

	public void setTwoNode(boolean twoNode) {
		this.twoNode = twoNode;
	}
	public boolean isHasSplit() {
		return hasSplit;
	}
	public void setHasSplit(boolean hasSplit) {
		this.hasSplit = hasSplit;
	}
	

}
