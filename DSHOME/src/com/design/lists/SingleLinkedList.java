
package com.design.lists;

public class SingleLinkedList {
	
	private SNode HEADER;
	
	public SNode getHEADER() {
		return HEADER;
	}

	public void setHEADER(SNode hEADER) {
		HEADER = hEADER;
	}

	public SingleLinkedList()
	{
		HEADER=null;
	}
	
	public void insert(int element)
	{
		SNode newNode=new SNode();
		newNode.data=element;
		newNode.next=HEADER;
		HEADER=newNode;
	}
	public boolean isEmpty()
	{
		return HEADER==null;
	}
	
	//Delete the front element
	
	public int delete()
	{
		SNode oldfirst=HEADER;
		HEADER=oldfirst.next;
		return oldfirst.data;
	}
	
	//Delete the SingleLinked List based on the search element
	public void delete(int element)
	{
		SNode cur=HEADER;
		SNode prev=cur; 
		if(cur==null)
		{
			//Find if the list is empty
			System.out.println("List is empty element cannot be deleted");
		}
		else
		{
			//Find the predecessor and the current position of the element
			while( cur!=null && cur.data!=element)
			{
				prev=cur;
				cur=cur.next;
			}
			
			if(cur==null || cur.data!=element)
			{
				System.out.println("Element not found");
			}
			else
			{
				prev.next=cur.next;
				System.out.println("Element deleted from the list");
			}
			
			
		}
		
	}
	//Display the list
	public void display()
	{
		SNode cur=HEADER;
		while(cur!=null)
		{
			System.out.print(cur.data+" ");
			cur=cur.next;
		}
	}
	public SNode reverse(SNode head)
	{
		SNode currentNode=head;
		SNode prevNode=null;
		SNode nextNode=null;
		while(currentNode!=null)
		{
			nextNode=currentNode.next;
			currentNode.next=prevNode;
			prevNode=currentNode;
			currentNode=nextNode;
		}
		return prevNode;
		
	}
	public void search(int element)
	{
		int result=searchR(element,HEADER);
		if(result==-1)
			System.out.println("Element not found");
		else
			System.out.println("Search Element found");
	}
	public int searchR(int element,SNode node)
	{
		if(node==null)  return -1;  //Element not found
		
		if(node.data==element)return 1;   //Element found 
	         
		else 
			return searchR(element,node.next);
	}

}
