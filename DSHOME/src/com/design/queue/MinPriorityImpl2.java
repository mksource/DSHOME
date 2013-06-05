package com.design.queue;

import com.design.lists.DNode;
import com.design.lists.DoublyLinkedList;
import com.design.utils.NotFoundException;

public class MinPriorityImpl2 implements IMinPriorityQueue{

	private DoublyLinkedList dlist;
	
	public MinPriorityImpl2()
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
		int i=1;
		int min=0;
		for(DNode node:dlist){
			if(i==1)
				min=node.data;
			else
				break;
		}
		return min ;
	}

	@Override
	public void insert(int x) {
		// TODO Auto-generated method stub
		//Search the position to inserted
		int i=-1;
		for(DNode node:dlist){
			
			if(x<node.data)break;
			i++;
		}
		dlist.insertAtPos(i+1,x);
		
	}

	@Override
	public int extractMin() {
		int min=0;
		try {
			min=dlist.deleteAtFront();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return min ;
		
	}

}
