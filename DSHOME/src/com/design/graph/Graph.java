package com.design.graph;

import com.design.arrays.Bag;
import com.design.utils.InputReader;

public class Graph {

	private int V;   //number of vertices
	private int E;   //number of Edges
	private Bag<Integer>[] adj;  //adajacency list
	
	//Create a V-vertex graph with no edges;
	public Graph(int v)
	{
		this.V=v;
		this.E=0;
		adj=new Bag[v];
		for(int i=0;i<v;i++)
			adj[i]=new Bag<Integer>();
	}
	
	//Read a Graph from the Input Stream in
	public Graph(InputReader in)
	{
		//read the number of vertices
		
		this(in.readInt());
		
		//read the number of edges 
		int E=in.readInt();
		
		//Read all the edges
		for(int i=0;i<E;i++)
		{
			//Read a vertex v 
			int v=in.readInt();
			
			//Read a vertex w
			int w=in.readInt();
			
			//Add a edge connecting then
			addEdge(v,w);
			
		}
	}
	
	//Return the number of vertices
	public int V()
	{
		return V;
	}
	
	//Return the number of Edges
	public int E()
	{
		return E;
	}
	
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	@Override
	public String toString()
	{
		String s=V+"vertices, "+E+"Edges\n";
		for(int v=0;v<V;v++)
		{
			s+=v+": ";
			for(int w : this.adj(v))
				s+=w+" ";
			s+="\n";
		}
		return s;
	}
	
	
	
	

}
