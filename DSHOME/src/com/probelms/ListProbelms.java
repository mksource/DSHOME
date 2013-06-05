package com.probelms;

import java.util.Stack;

import com.design.lists.SNode;
import com.design.lists.SingleLinkedList;
import com.design.utils.InputReader;

public class ListProbelms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListProbelms list=new ListProbelms();
		
		/*
		//Find the nth position from the end of the node
		list.findPosFromEnd();*/
		list.printNFromEnd(3);

	}
	public void printNFromEnd(int n)
	{
		/**
		 * The probelm is to print  the last n elements in the list in reverse orders
		 */
		InputReader in=new InputReader(getClass().getResourceAsStream("/list.txt"));
		SingleLinkedList list=new SingleLinkedList();
		Stack<Integer> stack=new Stack<Integer>();
		
		//Read the number of elements 
		int numOfElems=in.readInt();
		
		//Insert the elements into list
		for(int i=0;i<numOfElems;i++)
		{
			list.insert(in.readInt());
		}
		
		//Insert the elements into stack
		SNode cur=list.getHEADER();
		while(cur!=null){
			stack.push(list.delete());
			cur=cur.next;
		}
		//Print the last n elements in reverse order
		for(int i=0;i<n;i++)
			System.out.print(stack.pop());
		
	}
	public void findPosFromEnd()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/list.txt"));
		SingleLinkedList list=new SingleLinkedList();
		//Read number of elements
		int numOfElems=in.readInt();
		
		//Insert the elements into list
		for(int i=0;i<numOfElems;i++)
		{
			list.insert(in.readInt());
		}
		
		//Read the nth node from the end of the linked list
		int pos=in.readInt();
		
		
		
		list.display();
		
		/**
		 * Approach 1. Read the linked list till end and find the size say m
		 * and find then again we have to find the m-n+1 element to get nth node from end 
		 */
		int count=0;
		SNode current=list.getHEADER();
		while(current!=null){
			count++;
			current=current.next;
		}
		
		if(count>pos)
		{
			int readpos=count-pos;
			int i=0;
			current=list.getHEADER();
			while(i!=readpos){
				i++;
				current=current.next;
			}
			System.out.println("The "+pos+"th node from end is "+current.data);
		}
		else
		{
			System.out.println("Position cannot be read");
		}
		
		/**
		 * Approach 2.Have two pointers current and currentN 
		 * let both point to head start using currentN after N Nodes are read
		 */
		
		current=list.getHEADER();
		SNode currentN=list.getHEADER();
		count=0;
		while(current!=null)
		{
			count++;
			if(count-pos>0)
				currentN=currentN.next;
			current=current.next;
		}
		if(count>=pos)
			System.out.println("The "+pos+"th node from end is "+currentN.data);
		
	}

}
