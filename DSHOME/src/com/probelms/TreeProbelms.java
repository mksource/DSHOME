package com.probelms;

import java.util.Stack;

import com.design.queue.QueueList;
import com.design.trees.BinaryTree;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

public class TreeProbelms {

	/**
	 * @param args
	 */
	private int kcount=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		TreeProbelms probelm=new TreeProbelms();
		probelm.printReverseLevelOrder();
	}
	public void findKLargest(Node node,int k)
	{
		/**
		 * Algorithm to find the kth kargest in the binary search tree 
		 * Traverse in the order right element left 
		 * keep a static variable which is increemented each time a element is visited
		 * print the element when the count reaches count of k
		 */
		 findKLargest(node.right,k);
		 kcount++;
		if(kcount==k)
			System.out.println(node.key);
		findKLargest(node.left,k);
	} 
	public void printReverseLevelOrder()
	{
		/**
		 * To print the reverse of level order traversal we have to enqueue
		 * elements of tree and dequeue and push into stack
		 * Finally pop the stack to get the reverse of level order traversal
		 */
		
		BinaryTree tree=new BinaryTree(new InputReader(getClass().getResourceAsStream("/tree3.txt")));
		QueueList<Node> queue=new QueueList<Node>();
		Stack<Integer> stack=new Stack<Integer>();
		
		queue.enqueue(tree.getRoot());
		while(!queue.isEmpty())
		{
			Node element=queue.dequeue();
			if(element.left!=null)
				queue.enqueue(element.left);
			if(element.right!=null)
				queue.enqueue(element.right);
			stack.push(element.key);
			 
		}
		
		System.out.println("The reverse level order traversal of the tree is");
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	public void findPOSTPRE()
	{
		
	}
	

}
