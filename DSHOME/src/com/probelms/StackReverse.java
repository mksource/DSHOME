package com.probelms;

import java.util.Stack;

import com.design.utils.InputReader;

public class StackReverse {
	
	public static void main(String args[])
	{
		StackReverse rev=new StackReverse();
		rev.process();
	}
	public void process()
	{
		Stack<Integer> stack=new Stack<Integer>();
		InputReader in=new InputReader(getClass().getResourceAsStream("/stack.txt"));
		
		//Read the number of elements to be pushed into stack
		int push=in.readInt();
		
		for(int i=0;i<push;i++)
		{
			stack.push(in.readInt());
		}
		
		//Print the elements of the stack 
		for(int item:stack)
			System.out.print(item+" ");
		
		//Reverse the stack 
		reverseStack(stack);
		
		System.out.println("");
		//The elements of the stack after its contents are reversed
		for(int item:stack)
			System.out.print(item+" ");
		
	}
	public void reverseStack(Stack<Integer> s)
	{
		if(s.isEmpty())return;
		int data=s.pop();
		reverseStack(s);
		insertAtBottom(s,data);
	}
	public void insertAtBottom(Stack<Integer> s,int element)
	{
		if(s.isEmpty())
		{
			s.push(element);
			return;
		}
		int data=s.pop();
		insertAtBottom(s,element);
		s.push(data);
	}
}
