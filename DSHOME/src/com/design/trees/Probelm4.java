package com.design.trees;

import com.design.queue.QueueList;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

/*
 * Get the level of a node in the binary tree
 */
public class Probelm4 {

	public static void main(String args[])
	{
		Probelm4 p=new Probelm4();
		p.solve();
	}
	public void solve()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/tree5.txt"));
		BinaryTree tree=new BinaryTree(in);
		
		int target=7;
		boolean foundLevel=false;
		QueueList<Node> queue=new QueueList<Node>();
		queue.enqueue(tree.getRoot());
		int seen=0;  //number of nodes seen at this level i
		int excepted=1; //number of nodes excepted at this level
		int queued=0;    //number of nodes queued for next level i+1
		int level=1;
		while(!queue.isEmpty())
		{
			Node node=queue.dequeue();
			seen++;
			if(node.key==target)
			{
				foundLevel=true;
				break;
			}
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
			if(seen==excepted)
			{
				excepted=queued;
				seen=queued=0;
				level++;
			}
			
		}
		
		if(foundLevel)
		{
			System.out.println("Element found at the level"+level);
		}
		else
		{
			System.out.println("Element Not found");
		}
	}
}
