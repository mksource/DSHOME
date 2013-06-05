package com.design.lists;

import com.design.utils.InputReader;

public class CLListClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLListClient cllist=new CLListClient();
		cllist.process();
		

	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/cl.txt"));
		CircularLinkedList cllist=new CircularLinkedList();
		//Read the numbers of elements to inserted at front 
		int front=in.readInt();
		
		for(int i=0;i<front;i++)
		{
			cllist.insertAtFront(in.readInt());
		}
		
		//Print the list after inserting at front 
		cllist.printCircularListData();
		System.out.println("");
		
		//Read the number of elements to be inserted at end 
		int back=in.readInt();
		for(int j=0;j<back;j++)
		{
			cllist.insertAtEnd(in.readInt());
		}
		
		//Print the list after inserting at end 
		cllist.printCircularListData();
		System.out.println("");
		
		
		int deleteFront=in.readInt();
		int deleteEnd=in.readInt();
		
		//Delete elements at the front
		for(int i=0;i<deleteFront;i++)
		{
			cllist.deleteAtFront();
		}
		cllist.printCircularListData();
		System.out.println("");
		
		//Delete elements at the back
		for(int i=0;i<deleteEnd;i++)
		{
			cllist.deleteAtEnd();
		}
		cllist.printCircularListData();
		System.out.println("");
		
		System.out.println("The number of elements in the circular linked list: "+cllist.size());
		
		System.out.println("The middle element in the circular linked list is:"+cllist.findMiddle());
		
	}

}
