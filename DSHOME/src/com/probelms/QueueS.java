package com.probelms;

import java.util.Stack;

import com.design.utils.NotFoundException;
/**
 * 
 * @author karthik1
 * In order to implement a Queue using two stacks 
 * we have use two stacks pushstack and popstack
 * we have enqueue to a pushstack
 * In order to dequeue if the popstack is empty then we have to pop elements out of the pushstack
 * and return the top element
 * If the popstack is not empty return the top element
 *
 */
public class QueueS {

	/**
	 * @param args
	 */
	Stack<Integer> pushstack;
	Stack<Integer> popstack;
	
	public QueueS()
	{
		pushstack=new Stack<Integer>();
		popstack=new Stack<Integer>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void process()
	{
		
		
	}
	public void enqueue(int element)
	{
		pushstack.push(element);
	}
	public int dequeue(int element) throws NotFoundException
	{
		if(!popstack.isEmpty())
			return popstack.pop();
		else
		{
			if(pushstack.isEmpty())
			{
				System.out.println("Queue is empty");
				throw new NotFoundException("No element to be popped");
			}
			else
			{
				while(!pushstack.isEmpty())
				{
					popstack.push(pushstack.pop());
				}
				return popstack.pop();
			}
		}
	}

}
