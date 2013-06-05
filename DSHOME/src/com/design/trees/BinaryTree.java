package com.design.trees;

import java.util.ArrayList;

import com.design.trees.bst.Node;
import com.design.utils.InputReader;
import com.design.queue.QueueList;

public class BinaryTree {

	private Node root;
	private ArrayList<Node> insertarray;
	
	public Node getRoot()
	{
		return root;
	}
	public BinaryTree(InputReader in)
	{
		/**
		 * We are using level order traversal to insert elements
		 */
		//read the number of levels 
		int levels=in.readInt();
		
		int numelements=1;
		root=null;
		int elempos=0;
		insertarray=new ArrayList<Node>();
		
		in.advanceLine();
		
		for(int i=0;i<levels;i++)
		{
			String line=in.readLine();
			
			String elements[]=line.split(" ");
		
			
			if(elements.length!=numelements)
			{
				System.out.println("Please Insert "+numelements+" at level"+i);
				return;
			}
			for(int j=0;j<elements.length;j++)
			{
				if(!elements[j].equals("null")){
					Node newElem=new Node();
					newElem.key=Integer.parseInt(elements[j]);
					newElem.left=null;
					newElem.right=null;
					
					//Insert the node at its parent
					
					//Determine the number of the element
					
					if(elempos==0)
					{
						//The element if the root element
						root=newElem;
						insertarray.add(elempos,newElem);
					}
					else
					{
						//Determine the position of the parent
						int parent=0;
						//If the position is even the element has to be on left 
						if(elempos%2==0)
						{
							parent=(elempos-2)/2;
							Node parentElem=insertarray.get(parent);
							parentElem.right=newElem;
							insertarray.add(elempos, newElem);
							
						}
						//If the position is odd the element has to be on right
						else
						{
							parent=(elempos-1)/2;
							Node parentElem=insertarray.get(parent);
							parentElem.left=newElem;
							insertarray.add(elempos,newElem);
						}
					}
					
					
				}
				else
				{
					insertarray.add(elempos, null);
				}
				elempos++;
				
			}
			
			numelements*=2;
		}
	
	}
	
	public void traversal()
	{
		//LevelOrder Traversal
		QueueList<Node> queue=new QueueList<Node>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			Node elem=queue.dequeue();
			System.out.print(elem.key+" ");
			if(elem.left!=null)queue.enqueue(elem.left);
			if(elem.right!=null)queue.enqueue(elem.right);
		}
	}
	public void inOrder(Node node)
	{
		if(node==null)return;
		inOrder(node.left);
		System.out.print(node.key+" ");
		inOrder(node.right);
	}
	

}
