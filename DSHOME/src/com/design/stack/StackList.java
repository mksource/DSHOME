package com.design.stack;

import com.design.lists.DoublyLinkedList;
import com.design.utils.NotFoundException;

public class StackList {

	private DoublyLinkedList dllist;
	
	public StackList()
	{
		dllist=new DoublyLinkedList();
	}
	
	public void push(int element)
	{
		dllist.insertAtFront(element);
	}
	public int pop() throws NotFoundException
	{
		int element=dllist.deleteAtFront();
		return element;
	}
	public void display()
	{
		dllist.printDLList();
	}
	

}
