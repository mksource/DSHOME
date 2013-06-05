package com.design.queue;

public class Queue {
	
	
	private int front;
	private int rear;
	private int elements[];
	private int maxElems;
	private int numOfElems;
	
	public Queue(int N)
	{
		front=0;
		rear=0;
		numOfElems=0;
		maxElems=N;
		elements=new int[N];
	}
	
	
	public boolean isEmpty()
	{
		return numOfElems==0;
	}
	private boolean isFull()
	{
		return numOfElems==maxElems;
	}
	public void enqueue(int element)
	{
		if(isFull())
		{
			System.out.println("Queue is Full cannot insert");
		}
		else
		{
			elements[rear]=element;
			numOfElems++;
			rear=(rear+1)%maxElems;
		}
	}
	public int dequeue()
	{
		if(isEmpty())
		{
			System.out.println("Queue is Empty cannot Delete");
			return -1;
		}
		else
		{
			int old=elements[front];
			front=(front+1)%maxElems;
			numOfElems--;
			return old;
			
		}
	}

}
