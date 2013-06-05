package com.design.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueList<Item> implements Iterable<Item> {

	LinkedList<Item> list;
	
	public QueueList()
	{
		list=new LinkedList<Item>();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	public void enqueue(Item Element)
	{
		list.add(Element);
	}
	public Item dequeue()
	{
		return list.remove();
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return list.listIterator();
	}
	
	

}
