package com.design.dictionary;

public class SortedArrayDict implements Dictionary {

	//Acts as key for each element
	private int n;
	
	//Hold the values of the dictionary, index being the key
	int values[];
	
	public SortedArrayDict()
	{
		n=0;
		values=new int[10];
	}
	
	@Override
	public int Search(int key)  {
		// TODO Auto-generated method stub
		for(int i=0;i<n;i++)
		{
			if(values[i]==key)return i;
		}
		return -1;
	}

	@Override
	public void Insert(int x) {
		// TODO Auto-generated method stub
		values[n++]=x;
	}

	@Override
	public void Delete(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public int Max() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Min() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Successor(int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int Predecessor(int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
