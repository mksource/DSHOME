package com.design.trees;

/**
 * 
 * @author karthik
 * This Node is used to represent a Threaded Binary Tree 
 * LTAG=0 The node points to the left child 
 * LTAG=1 The node points to the in-order predecessor
 * RTAG=0 The node points to the right child
 * RTAG=1 The node points to the in-order successor 
 */

public class TNode {
	public int data;
	public TNode RNode;
	public TNode LNode;
	public int RTag;
	public int LTag;
}
