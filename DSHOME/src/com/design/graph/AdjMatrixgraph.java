package com.design.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.design.utils.InputReader;

public class AdjMatrixgraph {

	private int V;
	private int E;
	private boolean[][]adj;
	
	//empty graph with V vertices
	public AdjMatrixgraph(int v)
	{
		if(v<0)throw new RuntimeException("Number of vertices must be nonnegative");
		this.V=v;
		this.E=0;
		adj=new boolean[v][v];
	}
	
	//Graph read from the input 
	public AdjMatrixgraph(InputReader in)
	{
		//read the vertices 
		this(in.readInt());
		
		//read the number of Edges
		int E=in.readInt();
		
		//Add the edges
		for(int i=0;i<E;i++)
		{
			//read the vertex v
			int v=in.readInt();
			
			//read the vertex w
			int w=in.readInt();
			
			addEdge(v,w);
		}
	}
	//random graph with V vertices and E edges
	
	
	//Number of vertices and edges
	public int V(){return this.V;}
	public int E(){return this.E;}
	
	
	//add undirected edge v-w
	public void addEdge(int v,int w)
	{
		if(!adj[v][w])E++;
		adj[v][w]=true;
		adj[w][v]=true;
			
	}
	
	//does the graph contains the edge
	public boolean contains(int v,int w)
	{
		return adj[v][w];
	}
	
	//delete the edge between (v,w) in the graph
	public void deleteEdge(int v,int w)
	{
		adj[v][w]=false;
	}
	
	@Override
	public String toString()
	{
		String s="Vertices: "+V+" Edges: "+E+"\n";
		for(int i=0;i<V;i++)
		{
			s+=i+": ";
			for(int w:adj(i))
				s+=w+",";
			s+="\n";
		}
		return s;	
	}
	
	//returns the element adjacent to the vertex v
	public Iterable<Integer> adj(int v)
	{
		return new AdjIterator(v);
	}
	
	private class AdjIterator implements Iterator<Integer>,Iterable<Integer>{

		@Override
		public Iterator<Integer> iterator() {
			// TODO Auto-generated method stub
			return this;
		}
		int v=0,w=0;
		public AdjIterator(int v){this.v=v;}
	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			while(w<V){
				if(adj[v][w])return true;
				w++;
			}
			return false;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if(hasNext()){return w++;}
			else throw new NoSuchElementException();
			
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}	
	
}
