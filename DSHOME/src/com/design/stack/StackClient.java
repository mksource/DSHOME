package com.design.stack;

import com.design.utils.InputReader;
import com.design.utils.NotFoundException;

public class StackClient {
	
	public static void main(String args[])
	{
		StackClient client=new StackClient();
		client.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/stack.txt"));
		StackList stack=new StackList();
		
		//Get number the Elements to be inserted 
		int insert=in.readInt();
		
		//Get the Elements to be inserted
		for(int i=0;i<insert;i++)
		{
			stack.push(in.readInt());
		}
		
		//Display the Stack after elements have been pushed
		stack.display();
		System.out.println("");
		
		//Get the number of elements to be popped
		int pop=in.readInt();
		
		for(int i=0;i<pop;i++)
		{
			try {
				stack.pop();
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//Display the stack after it has been popped
		stack.display();
	}

}
