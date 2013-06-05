package com.design.queue;

import com.design.utils.InputReader;

public class MinPriorityQCl1 {
	
	public static void main(String args[])
	{
		MinPriorityQCl1 qc=new MinPriorityQCl1();
		qc.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/list.txt"));
		MinPriorityQImpl1 pq=new MinPriorityQImpl1();
		
		//Read the number of elements 
		int numOfElems=in.readInt();
		
		//Insert the element 
		for(int i=0;i<numOfElems;i++)
		{
			pq.insert(in.readInt());
		}
		
		int size=pq.size();
		System.out.println("The size of the priority queue is"+size);
		
		//Print the minimum elements one by one 
		for(int i=0;i<size;i++)
		{
			System.out.print("The next minimum element is:");
			System.out.print(pq.extractMin()+" ");
			System.out.println("");
		}
	}

}
