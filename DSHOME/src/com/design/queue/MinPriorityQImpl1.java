package com.design.queue;

import com.design.lists.DoublyLinkedList;
import com.design.lists.DNode;

/**
 * 
 * @author karthik1
 * Priority Queue implemented using an unsorted list
 * Insert at the back of the double linked list
 * Delete 
 */

public class MinPriorityQImpl1 implements IMinPriorityQueue{

	private DoublyLinkedList dlist;
	
	public MinPriorityQImpl1()
	{
		dlist=new DoublyLinkedList();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size=0;
		for(DNode node:dlist)
			size++;
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return dlist.isEmpty();
	}

	@Override
	public int min() {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		if(dlist.isEmpty())
			return -1;
		for(DNode node:dlist){
			if(node.data<min)
				min=node.data;
		}	
		return min;
	}

	@Override
	public void insert(int x) {
		// TODO Auto-generated method stub
		//insert at the back of the list 
		dlist.insertAtBack(x);
	}

	@Override
	public int extractMin() {
		// TODO Auto-generated method stub
		int min=Integer.MAX_VALUE;
		int pos=0;
		int i=-1;
		if(dlist.isEmpty())
			return -1;
		for(DNode node:dlist){
			 i++;
			if(node.data<min){
				min=node.data;
				pos=i;
			}	
		}	
		dlist.deleteAtPos(pos);
		return min;
	}

}
