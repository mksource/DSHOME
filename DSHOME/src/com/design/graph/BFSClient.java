package com.design.graph;

import com.design.utils.InputReader;

public class BFSClient {
	
	public static void main(String args[])
	{
		BFSClient bfs=new BFSClient();
		bfs.computePath(0);
	}
	public void computePath(int s)
	{
		InputReader in=new InputReader(getClass().getResourceAsStream("/dfs.txt"));
		Graph g=new Graph(in);
		System.out.println(g);
		BreadthFirstSearch search=new BreadthFirstSearch(g,s);
		
		System.out.println("The Shortest path for all the vertices from source");
		for(int i=0;i<g.V();i++) 
		{
			if(search.hasPathTo(i)){
				System.out.print(s+"to"+i+":");
				for(int w:search.pathTo(i))
				{
					if(w==s)System.out.print(w);
					else System.out.print("-"+w);
				}
				System.out.println("");
			}
			
		}
	}
	

}
