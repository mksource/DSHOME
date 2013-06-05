package com.design.lists;

public class CircularLinkedList {

	private SNode HEADER;
	
	public CircularLinkedList()
	{
		HEADER=null;
	}
	
	public void insertAtFront(int element)
	{
		SNode newNode=new SNode();
		newNode.data=element;
		if(HEADER==null)
		{
			HEADER=newNode;
			newNode.next=HEADER;
		}
		else
		{
			SNode current=HEADER;
			while(current.next!=HEADER)
				current=current.next;
			current.next=newNode;
			newNode.next=HEADER;
			HEADER=newNode;
		}
		
	}
	public void insertAtEnd(int element)
	{
		SNode newNode=new SNode();
		newNode.data=element;
		if(HEADER==null)
		{
			HEADER=newNode;
			newNode.next=HEADER;
		}
		else
		{
			SNode current=HEADER;
			while(current.next!=HEADER)
				current=current.next;
			current.next=newNode;
			newNode.next=HEADER;
		}
	}
	public void deleteAtFront()
	{
		if(HEADER==null)
		{
			System.out.println("List is empty cannot delete");
			return;
		}
		SNode current=HEADER;
		while(current.next!=HEADER)
			current=current.next;
		current.next=HEADER.next;
		HEADER=HEADER.next;
	}
	public void deleteAtEnd()
	{
		if(HEADER==null)
		{
			System.out.println("List is empty cannot delete");
			return;
		}
		SNode current=HEADER;
		SNode prev=current;
		while(current.next!=HEADER)
		{
			prev=current;
			current=current.next;
		}
		prev.next=HEADER;
	}
	public void printCircularListData()
	{
		SNode current=HEADER;
		if(HEADER==null)return;
		do{
			System.out.print(current.data+"->");
			current=current.next;
		}while(current!=HEADER);
				
	}
	public int size(){
		int count=0;
		SNode current=HEADER;
		if(current==null)return 0;
		do{
			count++;
			current=current.next;
		}while(current!=HEADER);
		return count;
		
	}
	public int  findMiddle()
	{
		//Find the number of elements 
		int size=this.size()/2;
		int i=0;
		SNode current=HEADER;
		
		while(i!=size)
		{
			current=current.next;
			i++;
		}
		return current.data;
		
	}
}
