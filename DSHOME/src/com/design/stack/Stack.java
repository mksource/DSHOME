package com.design.stack;

public class Stack {
	
	private int top;
	private int[] elements;
	private int numOfElems;
	
	public Stack(int N)
	{
		top=-1;
		elements=new int[N];
		numOfElems=N;
	}
	public boolean isEmpty()
	{
		return top==-1;
	}
	public boolean isFull()
	{
		return top==numOfElems-1;
	}
	public void push(int element)
	{
		if(isFull())
		{
			System.out.println("Stack is Full Cannot Insert");
		}
		else
		{
			elements[++top]=element;
		}
	}
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is Empty Cannot Delete");
			return -1;
		}
		else
		{
			return elements[top--];
		}
	}

}
