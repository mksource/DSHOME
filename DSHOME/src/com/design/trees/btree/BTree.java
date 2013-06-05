package com.design.trees.btree;

/**
 * 
 * @author karthik1
 * Properties of BTree 
 * i) All leaves are at same level
 * ii)A BTree is defined by term minimum degree 't'. The value of t depends upon disk block size
 * iii)Every node must contain atleast t-1 keys. The root may contain minimum one key
 * iv)All nodes (including root) may contain atmost 2t-1 keys
 * v)Number of children is equal to number of keys plus one 
 * vi)All the keys of the node are in increasing order. The child between the keys k1 and k2 contains
 *   all keys in the range k1 and k2
 * vii)The time complexity for search, delete , insert is O(logn)  
 * viii)BTree will always grow up rather growing down 
 */
public class BTree {

	private BTreeNode root;
	private int degree;
	
	public BTree(int degree)
	{
		this.degree=degree;
	}
	public void insert(int element)
	{
		
	}
	public void traverse()
	{
		
	}
	public boolean search()
	{
		return false;
	}
	

}
