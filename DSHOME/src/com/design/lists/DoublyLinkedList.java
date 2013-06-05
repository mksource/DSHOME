package com.design.lists;

import java.util.Iterator;

import com.design.utils.NotFoundException;

public class DoublyLinkedList implements Iterable<DNode>{
	
	//sentinel nodes to make the processing easier
	private DNode HEADER;
	private DNode TRAILER;
	
	public boolean isEmpty()
	{
		return HEADER.next==TRAILER;
	}
	public  DoublyLinkedList()
	{
		HEADER=new DNode();
		TRAILER=new DNode();
		
		HEADER.next=TRAILER;
		HEADER.prev=null;
		TRAILER.prev=HEADER;
		TRAILER.next=null;
	}
	public void insertAtFront(int element)
	{
		//Allocate new node
		DNode newNode=new DNode();
		newNode.data=element;
		
		DNode oldFirst=HEADER.next;
		newNode.next=oldFirst;
		oldFirst.prev=newNode;
		HEADER.next=newNode;
		newNode.prev=HEADER;
	}
	public void insertAtBack(int element)
	{
		DNode newNode=new DNode();
		newNode.data=element;
		
		DNode oldlast=TRAILER.prev;
		newNode.next=TRAILER;
		TRAILER.prev=newNode;
		oldlast.next=newNode;
		newNode.prev=oldlast;
	}
	public void insertAtPos(int position,int element)
	{
		DNode cur=HEADER.next;
		int size=0;
		while(cur!=TRAILER)
		{
			size++;
			cur=cur.next;
		}
		//Determine the position is valid or not
		//We are comparing with size+1 since we can insert at end
		if(position>size+1)
		{
			System.out.println("Invalid Position cannot insert");
			return;
		}
		//Traverse till will reach the position 
		int i=0;
		cur=HEADER.next;
		while(i!=position && cur!=TRAILER)
		{
			i++;
			cur=cur.next;
		}
		//Insert the element at position 
		DNode newNode=new DNode();
		newNode.data=element;
		DNode prevNode=cur.prev;
		newNode.prev=prevNode;
		prevNode.next=newNode;
		newNode.next=cur;
		cur.prev=newNode;
		
		
	}
	public void deleteAtPos(int position)
	{
		DNode cur=HEADER.next;
		int size=0;
		while(cur!=TRAILER)
		{
			size++;
			cur=cur.next;
		}
		//Determine the position is valid or not
		if(position>size)
		{
			System.out.println("Invalid Position cannot insert");
			return;
		}
		//Traverse till will reach the position 
		int i=0;
		cur=HEADER.next;
		while(i!=position)
		{
			i++;
			cur=cur.next;
		}
		//Delete the given node
		DNode posprev=cur.prev;
		DNode posnext=cur.next;
		posprev.next=posnext;
		posnext.prev=posprev;
	}
	public int deleteAtFront()throws NotFoundException
	{
		if(HEADER.next==TRAILER)
		{
			throw new NotFoundException("The list is empty cannot delete");
		}
		else
		{
			DNode delNode=HEADER.next;
			DNode newFirst=delNode.next;
			HEADER.next=newFirst;
			newFirst.prev=HEADER;
			return delNode.data;
		}
	}
	public int deleteAtBack() throws NotFoundException
	{
		if(HEADER.next==TRAILER)
		{
			throw new NotFoundException("The list is empty cannot delete");
		}
		else
		{
			DNode oldNode=TRAILER.prev;
			DNode newLast=oldNode.prev;
			TRAILER.prev=newLast;
			newLast.next=TRAILER;
			return oldNode.data;
		}
	}
	public void printDLList()
	{
		DNode current=HEADER.next;
		
		while(current!=TRAILER)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
	}
	@Override
	public Iterator<DNode> iterator() {
		// TODO Auto-generated method stub
		return new DList();
	}
	
	private class DList implements Iterator<DNode>
	{
		DNode current=HEADER.next;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=TRAILER;
		}

		@Override
		public DNode next() {
			// TODO Auto-generated method stub
			DNode next=current;
			current=current.next;
			return next;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
