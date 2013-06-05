package com.design.arrays;

public class BinarySearch {

	private int arr[];
	private int key;
	public BinarySearch(int a[],int key)
	{
		this.arr=a;
		this.key=key;
	}
	//Returns the positions where element is found if element exists otherwise will return -1
	public int search()
	{
		int low=0;
		int high=arr.length-1;
		int mid;
		while(low<=high)
		{
			mid=(low+high)/2;
			if(key==arr[mid])
				return mid;
			else if(key<arr[mid])
				high=mid-1;
			else
				low=mid+1;
				
		}
		return -1;
	}
}
