package com.design.trees;

import com.design.queue.QueueList;
import java.util.Stack;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

/*
 * To print the level order traversal of the tree in spiral form  or ZigZag Implementation
 */
public class Probelm6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Probelm6 p=new Probelm6();
		p.solve();

	}
	public void solve()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree5.txt"));
		BinaryTree tree=new BinaryTree(in);
		
		System.out.println("The ZigZag Order is");
		zigzagorder(tree);
	}
	public void zigzagorder(BinaryTree tree)
	{
		boolean spiral=true;  //variable to be used for making zigzag
		QueueList<Node> queue=new QueueList<Node>();
		Stack<Node> stack=new Stack<Node>();
		queue.enqueue(tree.getRoot());
		int seen=0;            //number of nodes seen at level i
		int excepted=1;        //number of nodes expected at level i
		int queued=0;         //number of nodes expected at level i+1
		while(!queue.isEmpty())
		{
			Node node=queue.dequeue();
			seen++;
			
			if(node.left!=null)
			{
				queue.enqueue(node.left);
				queued++;
			}
			if(node.right!=null)
			{
				queue.enqueue(node.right);
				queued++;
			}
			
			if(spiral)
			{
				stack.push(node);
			}
			else
			{
				System.out.print(node.key+" "); 
			}
			if(seen==excepted)
			{
				excepted=queued;
				seen=queued=0;
				spiral=!spiral;
				while(!stack.isEmpty())
					System.out.print(stack.pop().key+" ");
			}
		}
		
	}

}
