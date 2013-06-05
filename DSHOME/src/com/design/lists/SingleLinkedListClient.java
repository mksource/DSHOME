package com.design.lists;

public class SingleLinkedListClient {
	
	public static void main(String args[])
	{
		SingleLinkedList list=new SingleLinkedList();
		list.insert(10);
		list.insert(56);
		list.insert(90);
		list.insert(78);
		list.insert(34);
		list.insert(12);
		list.insert(7);
		
		list.search(90);
		list.search(98);
	}

}
