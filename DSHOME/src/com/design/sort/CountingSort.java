package com.design.sort;

import com.design.utils.InputReader;

/**
 * 
 * @author karthik1
 *	a. Counting Sort is based on keys in a range 
 *  b. Make a count array to store the count of each unique object
 *  c. Modify the count array such that each index contains the sum of previous index
 *  d.The modified countt array will now contain the position of each object
 *  e.Counting sort is not based on comparison this it is not  bounded  by O(nlogn)
 */
public class CountingSort {

	/**
	 * @param args
	 */
	private final int RANGE=9;
	private int arr[];
	private int countarr[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingSort sort=new CountingSort();
		sort.process();
	}
	public void process()
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/sort.txt"));
		
		int num=in.readInt();
		
		arr=new int[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=in.readInt();
		}
		countarr=new int[RANGE+1];
		countSort();
	}
	public void countSort()
	{
		//Initialize the count sort to zero 
		for(int i=0;i<countarr.length;i++)
			countarr[i]=0;
		//Parse the input sequence
		for(int i=0;i<arr.length;i++)
		{
			countarr[arr[i]]++;
		}
		
		//Modify the count array
		for(int i=0;i<countarr.length;i++)
			countarr[i]+=countarr[i-1];
		
		//build the sorted array
		int sortedarr[]=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			sortedarr[countarr[arr[i]]]=arr[i];
			countarr[arr[i]]--;
		}
	}

}
