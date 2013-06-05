package com.probelms;

import java.util.Stack;

import com.design.utils.InputReader;

/**
 * 
 * @author karthik1
 * To getMinimum element from the stack in 0(1) time we have to have another stack called 
 * minstack with these operations
 * 			i)Push- if the stack is empty then push the element otherwise the element is less 
 *                  than top of the element then insert into stack
 *          ii)Pop-if the element to be popped from the stack is equal to element on the top of the 
 *                 stack then pop the element from the minstack        
 */
public class StackMinimum {

	/**
	 * @param args
	 */
	Stack<Integer> stack;
	Stack<Integer> minstack;
	
	public StackMinimum()
	{
		stack=new Stack<Integer>();
		minstack=new Stack<Integer>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		StackMinimum min=new StackMinimum();
		min.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/stack.txt"));
		
		//Read the number of elements to pushed
		int pushnum=in.readInt();
		
		//Push the elements into the stack
		for(int i=0;i<pushnum;i++)
		{
			push(in.readInt());
		}
		
		//The current minimum element on the stack is 
		System.out.println("The current minimum on stack is:"+getMinimum());
		
		//Read the number of elements to popped
		int popnum=in.readInt();
		
		for(int i=0;i<popnum;i++)
		{
			pop();
			System.out.println("The current minimum on the stack is:"+getMinimum());
		}
		
		System.out.println("The current minimum on the stack is:"+getMinimum());
	}
	public void push(int element)
	{
		stack.push(element);
		if(minstack.isEmpty() || element<=minstack.peek())
			minstack.push(element);
		
	}
	public int pop()
	{
		int temp;
		if(stack.isEmpty())
			return -1;
		temp=stack.pop();
		if(temp==minstack.peek())
			minstack.pop();
		return temp;
	}
	public int getMinimum()
	{
		return minstack.peek();
	}

}
