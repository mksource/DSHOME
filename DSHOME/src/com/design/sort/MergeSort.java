package com.design.sort;

import com.design.utils.InputReader;

public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort sort=new MergeSort();
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
		mergeSort(arr);
	}
	public void mergeSort(int a[])
	{
		/*Divide and conquer algorithm uses an auxillary array for merge*/
		int aux[]=new int[a.length];
		System.out.println("The array to be sorted is");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		mergeSort(a,aux,0,a.length-1);
		
		//The Sorted array is 
		System.out.println("The Sorted array is");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
	}
	public void mergeSort(int a[],int aux[],int low,int high)
	{
		if(high<=low)return;
		int mid=low+(high-low)/2;
		mergeSort(a,aux,low,mid);
		mergeSort(a,aux,mid+1,high);
		merge(a,aux,low,mid,high);
		
	}
	public void merge(int a[],int aux[],int low,int mid,int high)
	{
		/**
		 * a[low....mid] is sorted in ascending order 
		 * a[mid+1....high]is sorted in ascending order
		 * using aux[low...high]
		 */
		for(int i=low;i<=high;i++)
			aux[i]=a[i];
		
		int i=low;
		int j=mid+1;
		for(int k=low;k<=high;k++)
		{
			if(i>mid)  a[k]=aux[j++];
			else if(j>high) a[k]=aux[i++];
			else if(aux[j]<aux[i]) a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}

}
