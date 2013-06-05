package com.design.trees.btree;

public class BTreeNode {
	
	int [] keys;  //array of keys
	int t;        //Minimum degree (Defines the range for number of keys)
	BTreeNode children[];   //pointers to child nodes
	int numOfKeys;
	boolean leaf;   //Is true when the current node is leaf is true otherwise false
	
	public BTreeNode(int _t,boolean _leaf)
	{
		//Minimum degree and leaf property 
		this.t=_t;
		this.leaf=_leaf;
		
		//Allocate memory for the number of keys and child pointers
		keys=new int[2*t-1];
		children=new BTreeNode[2*t];
		
		//Initialize the number of keys to zero
		numOfKeys=0;
	}

}
