package com.design.sort;
/*
 * Not a Stable Sorting algorithm meaning 
 * A sorting algorithm is called stable if it keeps elements with equal keys in the same relative order in the output as they were in the input.
For example, in the following input the two 4's are indistinguishable:
1,4a,3,4b,2
And so the output of a stable sorting algorithm must be:
1,2,3,4a,4b
Bubble sort, merge sort, counting sort ,insertion sort are stable sorting methods. Most implementations of quicksort are not stable sorts
 */
import com.design.utils.InputReader;

public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSort sort=new QuickSort();
		sort.process();
	}
	public void process()
	{

		InputReader in=new InputReader(getClass().getResourceAsStream("/sort.txt"));
		
		//Read the number of elements 
		int num=in.readInt();
		int arr[]=new int[num];
		for(int k=0;k<arr.length;k++)
		{
			arr[k]=in.readInt();
		}
		System.out.println("The array to be sorted is");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
		quicksort(arr,0,arr.length-1);
		//The Sorted array is 
		System.out.println("The Sorted array is");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	public void quicksort(int a[],int low,int high)
	{
		if(high<=low)return;
		int j=partition(a,low,high);
		quicksort(a,low,j-1);
		quicksort(a,j+1,high);
	}
	public int  partition(int a[],int low,int high)
	{
		/**
		 * increement the left index until we find a big element than pivot
		 * decreement the right index until we find a small element than pivot 
		 */
		//Select the pivotal element
		int pivot=a[low];
		
		//Initialize indices i and j to scan the array from left to right and from right to left
		int i=low;
		int j=high+1;
		
		while(true)
		{
			while(a[++i]<=pivot)
				if(i==high)break;
			while(a[--j]>=pivot)
				if(j==low)break;
			if(i>=j)break;
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		int temp=a[j];
		a[j]=pivot;
		a[low]=temp;
		return j;
	}

}
