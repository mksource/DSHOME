package com.design.trees;

import java.util.Stack;

import com.design.queue.QueueList;
import com.design.trees.bst.Node;
import com.design.utils.InputReader;

public class BinaryTreeClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			BinaryTreeClient client=new BinaryTreeClient();
			client.process();

	}
	public void process()
	{
		BinaryTree tree=new BinaryTree(new InputReader(getClass().getResourceAsStream("/tree3.txt")));
		
		
		System.out.println("The PreOrder traversal of tree using recursive method");
		preOrderR(tree.getRoot());
		
		System.out.println(" ");
		System.out.println("The PreOrder traversal of tree using non recursive method");
		preOrder(tree.getRoot());
		
		System.out.println(" ");
		System.out.println("The Inorder traversal of tree using recursive method");
		inOrderR(tree.getRoot());
		
		System.out.println("");
		System.out.println("The Inorder traversal of tree using non recursive method");
		inOrder(tree.getRoot());
		
		System.out.println("");
		System.out.println("The Post Order traversal of tree using recursive method");
		postOrderR(tree.getRoot());
		
		System.out.println("");
		System.out.println("The Post Order traversal of tree using non-recursive method");
		postOrder(tree.getRoot());
		
		System.out.println("");
		System.out.println("The level Order traversal of tree using level-order");
		levelOrder(tree.getRoot());
	}
	
	public void inOrderR(Node node)
	{
		if(node!=null)
		{
			inOrderR(node.left);
			System.out.print(node.key+" ");
			inOrderR(node.right);
		}
	}
	public void inOrder(Node node)
	{
		Stack<Node> stack=new Stack<Node>();
		
		while(true)
		{
			while(node!=null)
			{
				stack.push(node);
				node=node.left;
			}
			if(stack.isEmpty())break;
			
			node=stack.pop();
			System.out.print(node.key+" ");
			node=node.right;
		}
	}
	public void postOrderR(Node node)
	{
		if(node!=null)
		{
			postOrderR(node.left);
			postOrderR(node.right);
			System.out.print(node.key+" ");
		}
	}
	public void postOrder(Node node)
	{
		/**
		 * 1.1 create an empty stack 
		 * 2.1 Do the following with the root is not NULL
		 * 		a)Push root's child and root to the stack
		 * 	    b)Set root as root's left child
		 * 2.2 Pop an item from stack and set it as root 
		 * 	   a)If the popped item has a right child then set the right child as the root 
		 *       and then again push back the root to the stack
		 *     b)Else print root's data and set root as NULL
		 * 2.3 Repeat the steps 2.1 and 2.2 until stack is not empty       		
		 */
		
		//Check for empty condition 
		if(node==null)
			return;
		
		//Create a empty stack 
		Stack<Node> stack=new Stack<Node>();
		
		do{
			while(node!=null)
			{
				//Push the right child of the node if it exists to stack
				if(node.right!=null)
					stack.push(node.right);
				//Push the node to the stack
				stack.push(node);
				//Traverse to the left child
				node=node.left;
				
			}
			//Pop an item from stack and set it as root 
			node=stack.pop();
			
			//If the right child is not empty and if the right child is not processed yet
			if(node.right!=null && !stack.isEmpty() && stack.peek()==node.right){
				stack.pop();
				stack.push(node);
				node=node.right;
			}
			//Else print the node's data and set node as NULL
			else
			{
				System.out.print(node.key+" ");
				node=null;
			}
		}while(!stack.isEmpty());
		
	}
	public void preOrderR(Node node)
	{
		if(node!=null)
		{
			System.out.print(node.key+" ");
			preOrderR(node.left);
			preOrderR(node.right);
		}
	}
	public void preOrder(Node node)
	{
		Stack<Node> stack=new Stack<Node>();
		while(true)
		{
			while(node!=null)
			{
				//Visit the node 
				System.out.print(node.key+" ");
				
				//Push the node into Stack 
				stack.push(node);
				
				//If the left subtree exists then push it to stack
				node=node.left;
			}
			
			if(stack.isEmpty())break;
			
			node=stack.pop();
			node=node.right;
		}
	}
	public void levelOrder(Node root)
	{
		QueueList<Node> queue=new QueueList<Node>();
		queue.enqueue(root);
		
		while(!queue.isEmpty())
		{
			//Pop the entry from the queue print the data
			//if the node has left child and right child
			Node node=queue.dequeue();
			System.out.print(node.key+" ");
			if(node.left!=null)queue.enqueue(node.left);
			if(node.right!=null)queue.enqueue(node.right);
		}
	}
}	
