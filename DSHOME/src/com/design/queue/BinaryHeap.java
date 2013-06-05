package com.design.queue;

/**
 * 
 * @author karthik1
 * a)Binary Heap is a data structure that can support basic priority queue implementation
 * b)Items are stored in such a way that each key is larger than(equal to)the keys at two 
 *   other specific positions 
 * c)Can be defined using complete heap-ordered binary tree 
 * d)but is implemented using array where the first position is not used  using level order
 * e)Given a node at position k the parent of the node is at position k/2
 * f)Given a node at positiron k the children of the node is at positions 2*k and 2*k+1
 *
 */
public class BinaryHeap {

	private int pq[];
	private int N;
	public BinaryHeap(int n)
	{
		N=n;
		pq=new int[n+1];
		pq[0]=0; //don't use the first entry in the array to represent the heap
	}
	public int getMax()
	{
		return pq[1];
	}
	public int delMax()
	{
		return 0;
	}
	public int size()
	{
		return N;
	}
	public void insert(int element)
	{
		
	}
	private void exch(int i,int j)
	{
		int temp=pq[i];
		pq[i]=pq[j];
		pq[j]=temp;
		
	}
	private boolean less(int i,int j)
	{
		return pq[i]<pq[j];
	}
	private void swim(int k)
	{
		while(k>1 && less(k/2,k))
		{
			exch(k/2,k);
			k=k/2;
		}
	}
	private void sink(int k)
	{
		//until  we do not find the end of the array or if the heap condition is satisfied
		while(2*k<=N)
		{
			//first we have to find the largest of the left child and right child
			int j=2+k;
			if(j<N && less(j,j+1))j++;
			if(!less(k,j))break;
			exch(k,j);
			k=j;
			
			
		}
	}

}
