package com.design.queue;

public interface IMinPriorityQueue {

	//Returns the number of entries 
	public int size();
	
	//Test Whether the PriorityQueue is empty
	public boolean isEmpty();
	
	//Return the minimum key from the priority queue
	public int min();
	
	//Insert the value x into the priority queue
	public void insert(int x);
	
	//Extract the minimum key from the priority queue and also return it
	public int extractMin();
}
