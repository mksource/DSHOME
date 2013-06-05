package com.probelms;

import java.util.Stack;

import com.design.lists.SingleLinkedList;

public class ListAdd {
	
	public static void main(String args[])
	{
		SingleLinkedList list1=new SingleLinkedList();
		SingleLinkedList list2=new SingleLinkedList();
		Stack<Integer> stack=new Stack<Integer>();
		
		list1.insert(1);
		list1.insert(5);
		list1.insert(4);
		list1.insert(3);
		
		list2.insert(9);
		list2.insert(8);
		list2.insert(4);
		list2.insert(7);
		
		//list1.display();
		//list2.display();
		
		//Add the lists
		while(!list1.isEmpty() && !list2.isEmpty())
		{
			int element1=list1.delete();
			int element2=list2.delete();
			int sum=element1+element2;
			stack.push(sum);
			
		}
		int carryover=0;
		int finalsum=0;
		int multi=1;
		while(!stack.isEmpty())
		{
			
			
			int sum=stack.pop()+carryover;
			System.out.println(sum);
			if(sum>10)
			{
				finalsum+=multi*(sum%10);
				carryover=1;
				multi*=10;
				
			}
			else
			{
				carryover=0;
				finalsum+=multi*(sum);
				multi*=10;
			}
			
		}
		
		System.out.println("The sum of two lists is"+finalsum);
		
	}

}
