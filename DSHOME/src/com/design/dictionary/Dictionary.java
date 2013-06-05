package com.design.dictionary;



public interface Dictionary {
	
	//Searches the dictionary for the key if it found  returns its position
	//otherwise returns -1
	public int Search(int key);
	
	//Given a data item x  add it to the dictionary 
	public void Insert(int x);
	
	//Given a data item x Delete it from dictionary 
	public void Delete(int x);
	
	//Returns the maximum element in the dictionary
	public int Max();
	
	//Returns the minimum element in the dictionary
	public int Min();
	
	//Returns the next element after k in the sorted order
	public int Successor(int k);
	
	//Returns the previous element before k in the sorted order
	public int Predecessor(int k);
	

}
