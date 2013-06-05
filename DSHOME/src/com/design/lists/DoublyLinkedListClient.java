package com.design.lists;

import com.design.utils.InputReader;
import com.design.utils.NotFoundException;

public class DoublyLinkedListClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedListClient client=new DoublyLinkedListClient();
		try {
			client.process();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void process() throws NotFoundException
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/cl.txt"));
		
		DoublyLinkedList dlist=new DoublyLinkedList();
		//Read the numbers of elements to inserted at front 
		int front=in.readInt();
		
		for(int i=0;i<front;i++)
		{
			dlist.insertAtFront(in.readInt());
		}
		
		//Print the list after inserting at front 
		dlist.printDLList();
		System.out.println("");
		
		//Read the number of elements to be inserted at end 
		int back=in.readInt();
		for(int j=0;j<back;j++)
		{
			dlist.insertAtBack(in.readInt());
		}
		
		//Print the list after inserting at end 
		dlist.printDLList();
		System.out.println("");
		
		
		int deleteFront=in.readInt();
		int deleteEnd=in.readInt();
		
		//Delete elements at the front
		for(int i=0;i<deleteFront;i++)
		{
			dlist.deleteAtFront();
		}
		dlist.printDLList();
		System.out.println("");
		
		//Delete elements at the back
		for(int i=0;i<deleteEnd;i++)
		{
			dlist.deleteAtBack();
		}
		dlist.printDLList();
		System.out.println("");
	}

}
