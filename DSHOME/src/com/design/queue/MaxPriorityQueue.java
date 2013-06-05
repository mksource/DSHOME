package com.design.queue;

import com.design.queue.BinaryHeap;

public class MaxPriorityQueue {

		BinaryHeap heap;
		public MaxPriorityQueue()
		{
			
		}
		public MaxPriorityQueue(int max)
		{
			//Initialize the priority queue with max number of elements
			 heap=new BinaryHeap(max);
		}
		public MaxPriorityQueue(int a[])
		{
			//Initialize the priority queue with this array
		}
		//Return largest key
		public int max()
		{
			return 0;
		}
		//Return and remove largest key
		public int delMax()
		{
			return 0;
		}
		//Return true if the priority queue is empty
		public boolean isEmpty()
		{
			return heap.size()==0;
		}
		//Return the size of the priority queue
		public int size()
		{
			return heap.size();
		}

}
