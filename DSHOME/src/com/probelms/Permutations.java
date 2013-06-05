package com.probelms;

/**
 * 
 * @author karthik1
 * Johnson-Trotter algorithm 
 * Give a positive integer n algorithm generated a permutation of {1...n} in non-lexicographical order
 * 
 *  
 * * */
class Element{
	int element;
	String direction;//LEFT and right
}

public class Permutations {
	

	/**
	 * @param args
	 */
	private Element permutations[];
	private int numOfElems;
	private final String DIRECTION_LEFT="left";
	private final String DIRECTION_RIGHT="right";
	
	public Permutations(int n)
	{
		//Initialize the permutation array
		permutations=new Element[n];
	    for(int i=0;i<n;i++)
	    {
	    	permutations[i].element=i+1;
	    	permutations[i].direction=DIRECTION_LEFT;
	    }
		this.numOfElems=n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Permutations permute=new Permutations(3);
		permute.findPermutations();
	}
	//This method prints out the permutations of all n integers
	public void findPermutations()
	{
		/**
		 * Initialize the first permutation with <1 <2 <3
		 * while there is exists a mobile interger do
		 * 			find the largest mobile integer k
		 * 			swap k and the adjacent element its arrow points to
		 * 			reverse the directions of all integers that are larger than k 
		 * 			print the permutation
		 */
		while(ifMobileIntegerExists())
		{
			Element largest=nextLargestMobileInteger();
			
		}
		
	}
	//This method tells whether a mobile integer exists in the sequence
	public boolean ifMobileIntegerExists()
	{
		for(int i=0;i<numOfElems;i++)
		{
			boolean isMobile=isMobile(i);
			if(isMobile)return true;
		}
		return false;
	}
	//This method tell whether a given element index is mobile or not 
	public boolean isMobile(int index)
	{
		Element pert=permutations[index];
		Element adj=null;
		//If the direction is left
		if(pert.direction.equals(DIRECTION_LEFT))
		{
			//If it is the leftmost element then return false
			if(index==0)
				return false;
			else
			{
				//Get the adjacent element to left of the sequence
				adj=permutations[index-1];
				if(pert.element>adj.element)
					return true;
				else
					return false;
			}
		}
		//If the direction is right
		else
		{
			//If it is the rightmost element of 
			if(index==numOfElems-1)
				return false;
			else
			{
				//Get the adjacent element to left of the sequence
				adj=permutations[index+1];
				if(pert.element>adj.element)
					return true;
				else
					return false;
			}
		}
		
	}
	//Next largest mobile integer in the stream
	public Element nextLargestMobileInteger()
	{
		Element largestMobile=null;
		for(int i=0;i<numOfElems;i++)
		{
			boolean isMobile=isMobile(i);
			if(isMobile)
			{
				if(largestMobile==null)
					largestMobile=permutations[i];
				else if(largestMobile.element<permutations[i].element)
					largestMobile=permutations[i];
			}
		}
		return largestMobile;
	}
	//swap the element and the adjacent integer it arrow points to
	public void swap(int index)
	{
		Element elem1=permutations[index];
		Element elem2=null;
		if(elem1.direction.equals(DIRECTION_LEFT))
		{
			elem2=permutations[index-1];
		}
		else
		{
			elem2=permutations[index+1];
		}
		Element temp=elem1;
		elem1=elem2;
		elem2=temp;
	}
	//reverse the direction 
	public void reverse(int index)
	{
		Element elem=permutations[index];
		for(int i=0;i<numOfElems;i++)
		{
			Element temp=permutations[i];
			if(temp.element>elem.element)
				temp.direction=temp.direction.equals(DIRECTION_LEFT)?DIRECTION_RIGHT:DIRECTION_LEFT;
		}
	}

}
