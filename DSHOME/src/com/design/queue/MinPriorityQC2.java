package com.design.queue;

import com.design.utils.InputReader;

public class MinPriorityQC2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinPriorityQC2 queue=new MinPriorityQC2();
		queue.process();

	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/list.txt"));
		MinPriorityImpl2 pq=new MinPriorityImpl2();
		
		//Read the number of elements 
		int num=in.readInt();
		
		//Insert the elements into queue
		for(int i=0;i<num;i++)
		{
			pq.insert(in.readInt());
		}
		
		int size=pq.size();
		System.out.println("The number of elements in priority queue is"+size);
		
		for(int i=0;i<size;i++)
		{
			System.out.print(pq.extractMin()+" ");
		}
	}

}
