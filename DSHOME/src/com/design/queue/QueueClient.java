package com.design.queue;

public class QueueClient {
	
	public static void main(String args[])
	{
		Queue queue=new Queue(5);
		
		queue.enqueue(90);
		queue.enqueue(12);
		queue.enqueue(78);
		queue.enqueue(45);
		queue.enqueue(23);
		queue.enqueue(89);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}
