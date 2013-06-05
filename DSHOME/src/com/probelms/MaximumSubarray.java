package com.probelms;

public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray max=new MaximumSubarray();
		max.process();
	}
	public void process()
	{
		int arr[]={-2,-3,4,-1,-2,1,5,-3};
		int maximum=maximumSubArray(arr);
		System.out.println("The maximum sum of contigious subarray within a one-dimensional subarray"+maximum);
		rearrangeArray(arr);
	}
	public int  maximumSubArray(int a[])
	{
		//Using Kadane's algorithm
		int max_so_far=0;
		int max_end_far=0;
		
		for(int i=0;i<a.length;i++)
		{
			max_end_far=max_end_far+a[i];
			if(max_end_far<0)
				max_end_far=0;
			if(max_so_far<max_end_far)
				max_so_far=max_end_far;
		}
		return max_so_far;
	}
	public void rearrangeArray(int a[])
	{
		//Given an array with positive and negative numbers given in any order 
		//arrange the array such that we have negative numbers first 
		//Positive numbers next in the array 
		int aux[]=new int[a.length+1];
		
		aux[0]=0;
		for(int i=0;i<a.length;i++)
		{
			aux[i+1]=a[i];
		}
		int i=0;
		int j=aux.length;
		int pivot=aux[0];
		
		while(true)
		{
			while(aux[++i]<=pivot)
				if(i==aux.length)break;
			while(aux[--j]>=pivot)
				if(j==0)break;
			if(i>=j)break;
			int temp=aux[i];
			aux[i]=aux[j];
			aux[j]=temp;
			
		}
		int temp=aux[0];
		aux[0]=aux[j];
		aux[j]=temp;
		
		System.out.println("The rearranged array is");
		for(int k=0;k<aux.length;k++)
			System.out.print(aux[k]+" ");
			
			
		
	}

}
